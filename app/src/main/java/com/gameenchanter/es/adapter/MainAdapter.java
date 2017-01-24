package com.gameenchanter.es.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.List;

public class MainAdapter extends PagerAdapter {
    private static final String TAG = "ProductPhotoAdapter";
    private Context context;
    private List<View> views;
//    private ItemClickListener listener;

    public MainAdapter(Context context, List<View> views) {
        this.context = context;
        this.views = views;
    }

    /**
     * PagerAdapter管理数据大小
     */
    @Override
    public int getCount() {
        return views.size();
    }

    /**
     * 关联key 与 obj是否相等，即是否为同一个对象
     */
    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj; // key
    }

    /**
     * 销毁当前page的相隔2个及2个以上的item时调用
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
//        container.removeView((View) object); // 将view 类型 的object熊容器中移除,根据key
//        PhotoViewPager itemView = (PhotoViewPager) object;
//        itemView.recycle();
    }

    /**
     * 当前的page的前一页和后一页也会被调用，如果还没有调用或者已经调用了destroyItem
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        ViewParent vp = view.getParent();
        if (vp != null) {
            ViewGroup parent = (ViewGroup) vp;
            parent.removeView(view);
        }

//        if (listener != null) {
//            if (position == 0) {
//                listener.onItemClick(view);
//            }
//        }
        container.addView(view);
        return view;
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {

    }

    @Override
    public Parcelable saveState() {
        return null;
    }

//    public void setOnItemClickListener(ItemClickListener listener) {
//        this.listener = listener;
//    }
//
//    public interface ItemClickListener {
//        void onItemClick(View view);
//
//    }
}