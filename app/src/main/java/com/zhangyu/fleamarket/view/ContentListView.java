package com.zhangyu.fleamarket.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ListView;

import com.wandoujia.image.ImageManager;
import com.zhangyu.fleamarket.R;
import com.zhangyu.fleamarket.app.FleaMarketApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xubin@wandoujia.com
 */
public class ContentListView extends ListView {
  private final CompositeScrollListener compositeScrollListener =
      new CompositeScrollListener();
  private final ImageManager imageManager = FleaMarketApplication.getImageManager();
  private final OnScrollListener imageLoadingOnScrollListener =
      new OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
          // TODO(xubin): test this carefully, may have some problem in some devices.
          if (scrollState == SCROLL_STATE_IDLE) {
            imageManager.resumeImageLoading();
          } else {
            imageManager.pauseImageLoading();
          }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
            int totalItemCount) {}
      };
  private boolean showShadow = false;
  private View shadowView;

  public ContentListView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public ContentListView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public ContentListView(Context context) {
    super(context);
  }

  {
    super.setOnScrollListener(compositeScrollListener);
  }

  /**
   * Add an OnScrollListener, will not replace the previous added OnScrollListener.
   * <p>
   * <b>Make sure call this on UI thread</b>
   * </p>
   * 
   * @param listener the listener to add
   */
  @Override
  public void setOnScrollListener(final OnScrollListener listener) {
    addOnScrollListener(listener);
  }

  /**
   * Add an OnScrollListener, will not replace the previous added OnScrollListener.
   * <p>
   * <b>Make sure call this on UI thread</b>
   * </p>
   * 
   * @param listener the listener to add
   */
  public void addOnScrollListener(final OnScrollListener listener) {
    throwIfNotOnMainThread();
    compositeScrollListener.addOnScrollListener(listener);
  }

  /**
   * Remove a previous added scrollListener, will only remove exact the same object.
   * <p>
   * <b>Make sure call this on UI thread.</b>
   * </p>
   * 
   * @param listener the listener to remove
   */
  public void removeOnScrollListener(final OnScrollListener listener) {
    throwIfNotOnMainThread();
    compositeScrollListener.removeOnScrollListener(listener);
  }

  /**
   * Need to call before call setOnScrollListener.
   * 
   * @param shadowView the shadow view
   */
  public void setTopShadowView(View shadowView) {
    if (shadowView == null) {
      return;
    }
    this.shadowView = shadowView;
    addOnScrollListener(new OnScrollListener() {

      @Override
      public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
          int totalItemCount) {
        View firstChild = view.getChildAt(0);
        if (firstChild != null) {
          if (firstVisibleItem == 0 && firstChild.getTop() == 0) {
            showShadow = false;
            hideTopShadow();
          } else if (!showShadow) {
            showShadow = true;
            showTopShadow();
          }
        }
      }

      @Override
      public void onScrollStateChanged(AbsListView view, int scrollState) {}
    });
  }

  private void showTopShadow() {
    if (shadowView == null || shadowView.getVisibility() == View.VISIBLE) {
      return;
    }
    shadowView.setVisibility(View.VISIBLE);
    Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.short_fade_in);
    shadowView.startAnimation(anim);
  }

  private void hideTopShadow() {
    if (shadowView == null || shadowView.getVisibility() == View.GONE) {
      return;
    }
    Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.short_fade_out);
    anim.setAnimationListener(new Animation.AnimationListener() {

      @Override
      public void onAnimationStart(Animation animation) {}

      @Override
      public void onAnimationRepeat(Animation animation) {}

      @Override
      public void onAnimationEnd(Animation animation) {
        shadowView.setVisibility(View.GONE);
      }
    });
    shadowView.startAnimation(anim);
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    addOnScrollListener(imageLoadingOnScrollListener);
    ViewParent parent = getParent();
    while (parent != null) {
      if (parent instanceof ScrollDownLayout) {
        ((ScrollDownLayout) parent).setAssociatedListView(this);
        break;
      }
      parent = parent.getParent();
    }
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    imageManager.resumeImageLoading();
    removeOnScrollListener(imageLoadingOnScrollListener);
  }

  private void throwIfNotOnMainThread() {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Must be invoked from the main thread.");
    }
  }

  private class CompositeScrollListener implements OnScrollListener {
    private final List<OnScrollListener> scrollListenerList = new
        ArrayList<OnScrollListener>();

    public void addOnScrollListener(OnScrollListener listener) {
      if (listener == null) {
        return;
      }
      for (OnScrollListener scrollListener : scrollListenerList) {
        if (listener == scrollListener) {
          return;
        }
      }
      scrollListenerList.add(listener);
    }

    public void removeOnScrollListener(OnScrollListener listener) {
      if (listener == null) {
        return;
      }
      Iterator<OnScrollListener> iterator = scrollListenerList.iterator();
      while (iterator.hasNext()) {
        OnScrollListener scrollListener = iterator.next();
        if (listener == scrollListener) {
          iterator.remove();
          return;
        }
      }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
      List<OnScrollListener> listeners = new ArrayList<OnScrollListener>(scrollListenerList);
      for (OnScrollListener listener : listeners) {
        listener.onScrollStateChanged(view, scrollState);
      }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
        int totalItemCount) {
      List<OnScrollListener> listeners = new ArrayList<OnScrollListener>(scrollListenerList);
      for (OnScrollListener listener : listeners) {
        listener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
      }
    }
  }
}
