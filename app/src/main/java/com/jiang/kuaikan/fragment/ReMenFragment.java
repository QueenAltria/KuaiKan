package com.jiang.kuaikan.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.google.gson.Gson;
import com.jiang.kuaikan.R;
import com.jiang.kuaikan.activitys.QuanJiActivity;
import com.jiang.kuaikan.adapter.HuoDongAdapter;
import com.jiang.kuaikan.adapter.MeiZhouAdapter;
import com.jiang.kuaikan.adapter.RenQiAdapter;
import com.jiang.kuaikan.dao.BannerJson;
import com.jiang.kuaikan.dao.ReMenJson;
import com.jiang.kuaikan.views.CustomGridView;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Administrator on 2016/5/27.
 */
public class ReMenFragment extends Fragment {
    ConvenientBanner convenientBanner;
    List<BannerJson.DataBean.BannerGroupBean> banner_group=new ArrayList<>();
    List<String> networkImages=new ArrayList<>();
    SwipeRefreshLayout mSwipeRefreshLayout;
    GridView mGridView1,mGridView4;
    CustomGridView mGridView2,mGridView3;
    ImageView mImageView1,mImageView2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remen_fragment, null);
        convenientBanner= (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        mSwipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorYellow);
        mGridView1= (GridView) view.findViewById(R.id.renqigrid);
        mGridView2= (CustomGridView) view.findViewById(R.id.meizhougrid);
        mGridView3= (CustomGridView) view.findViewById(R.id.lituigrid);
        mGridView4=(GridView) view.findViewById(R.id.huodonggrid);

        mImageView1= (ImageView) view.findViewById(R.id.xinzuo_one);
        mImageView2= (ImageView) view.findViewById(R.id.xinzuo_two);


        getBanner();
        getData();
        gridClick();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(3000);
    }

    public void getBanner(){

        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/banners");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                //LogUtil.e(result);
                BannerJson bannerJson = gson.fromJson(result, BannerJson.class);
                banner_group.clear();
                banner_group = bannerJson.getData().getBanner_group();
                for (int i = 0; i < banner_group.size(); i++) {
                    networkImages.add(banner_group.get(i).getPic());
                    //LogUtil.e(banner_group.get(i).getPic()+"--------");
                }
                convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                }, networkImages).setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                        .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);

                mSwipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public void getData(){
        RequestParams entity = new RequestParams("http://api.kuaikanmanhua.com/v1/topic_lists/mixed/new");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                ImageOptions options = new ImageOptions.Builder()
                        // 是否忽略GIF格式的图片
                        .setIgnoreGif(false)
                                // 图片缩放模式
                        .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                                // 下载中显示的图片
                        .setLoadingDrawableId(R.drawable.ic_common_placeholder_l)
                                // 下载失败显示的图片
                        .setFailureDrawableId(R.drawable.ic_common_placeholder_l)
                                // 得到ImageOptions对象
                        .build();
                Gson gson=new Gson();
                ReMenJson reMenJson = gson.fromJson(result, ReMenJson.class);
                final List<ReMenJson.DataBean.InfosBean.TopicsBean> topics = reMenJson.getData().getInfos().get(0).getTopics();
                topics.remove(3);
                RenQiAdapter adapter=new RenQiAdapter(topics,ReMenFragment.this.getActivity());
                mGridView1.setAdapter(adapter);
                mGridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String id = String.valueOf(topics.get(i).getId());
                        Intent intent = new Intent(ReMenFragment.this.getActivity(), QuanJiActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                });

                List<ReMenJson.DataBean.InfosBean.TopicsBean> topics_meizhou = reMenJson.getData().getInfos().get(1).getTopics();
                MeiZhouAdapter meiZhouAdapter=new MeiZhouAdapter(topics_meizhou,ReMenFragment.this.getActivity());
                mGridView2.setAdapter(meiZhouAdapter);

                final List<ReMenJson.DataBean.InfosBean.TopicsBean> topics_xinzuo = reMenJson.getData().getInfos().get(2).getTopics();
                x.image().bind(mImageView1,topics_xinzuo.get(0).getDiscover_image_url(),options);
                x.image().bind(mImageView2, topics_xinzuo.get(1).getDiscover_image_url(), options);
                mImageView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id = String.valueOf(topics_xinzuo.get(0).getId());
                        Intent intent = new Intent(ReMenFragment.this.getActivity(), QuanJiActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    }
                });
                mImageView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String id = String.valueOf(topics_xinzuo.get(1).getId());
                        Intent intent=new Intent(ReMenFragment.this.getActivity(), QuanJiActivity.class);
                        intent.putExtra("id",id);
                        startActivity(intent);
                    }
                });

                List<ReMenJson.DataBean.InfosBean.TopicsBean> topics_litui = reMenJson.getData().getInfos().get(3).getTopics();
                RenQiAdapter lituiadapter=new RenQiAdapter(topics_litui,ReMenFragment.this.getActivity());
                mGridView3.setAdapter(lituiadapter);


                List<ReMenJson.DataBean.InfosBean.BannerBean> banners = reMenJson.getData().getInfos().get(4).getBanners();
                banners.remove(2);
                HuoDongAdapter huoDongAdapter=new HuoDongAdapter(banners,ReMenFragment.this.getActivity());
                mGridView4.setAdapter(huoDongAdapter);

                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    public void gridClick(){
        mGridView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ReMenJson.DataBean.InfosBean.BannerBean banner= (ReMenJson.DataBean.InfosBean.BannerBean) adapterView.getItemAtPosition(i);
                Toast.makeText(ReMenFragment.this.getActivity(), banner.getTarget_title(), Toast.LENGTH_SHORT).show();
            }
        });

        mGridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ReMenJson.DataBean.InfosBean.TopicsBean topic= (ReMenJson.DataBean.InfosBean.TopicsBean) adapterView.getItemAtPosition(i);
                String id=String.valueOf(topic.getId());
                Intent intent=new Intent(ReMenFragment.this.getActivity(), QuanJiActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });
        mGridView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ReMenJson.DataBean.InfosBean.TopicsBean topic= (ReMenJson.DataBean.InfosBean.TopicsBean) adapterView.getItemAtPosition(i);
                String id=String.valueOf(topic.getId());
                Intent intent=new Intent(ReMenFragment.this.getActivity(), QuanJiActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });

    }



    public class NetworkImageHolderView implements Holder<String> {
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context,int position, String data) {
            x.image().bind(imageView, data);
        }
    }

}
