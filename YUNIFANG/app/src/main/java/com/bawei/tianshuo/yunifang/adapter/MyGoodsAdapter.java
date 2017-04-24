package com.bawei.tianshuo.yunifang.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.bawei.tianshuo.yunifang.R;
import com.bawei.tianshuo.yunifang.activity.GoodsWebView;
import com.bawei.tianshuo.yunifang.bean.Goods;
import com.bawei.tianshuo.yunifang.selfView.Infinite_View_Pager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/21
 */

public class MyGoodsAdapter  extends RecyclerView.Adapter<MyGoodsAdapter.MyGoodsViewHolder> {
   private Goods.DataBean goods;
    private Context context;
    private final int TYPE0=0;
    private final int TYPE1=1;
    private final int TYPE2=2;
    private final int TYPE3=3;
    private final int TYPE4=4;
    private boolean flag=true;

    public MyGoodsAdapter(Goods.DataBean goods, Context context) {
        this.goods = goods;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        if (position==0){
            return TYPE0;
        }else if (position==1){
            return TYPE1;
        }else if (position==2){
            return  TYPE2;
        }else if (position==3){
            return  TYPE3;
        }else if (position==4){
            return TYPE4;
        }
        return super.getItemViewType(position);
    }

    private MyAdapterClassify.OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(View v,int position);
    }
    public void setOnItemClickListener(MyAdapterClassify.OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    @Override
    public MyGoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      if (viewType==TYPE0){
          View view= LayoutInflater.from(context).inflate(R.layout.goods_viewpager,parent,false);;
          MyHolder0 holder0=new MyHolder0(view);
           return holder0;
     }if (viewType==TYPE1){
            View view= LayoutInflater.from(context).inflate(R.layout.goods_info_title,parent,false);
            final MyHolder1 holder1=new MyHolder1(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder1.getLayoutPosition();
                    //注册点击监听
                    if (onItemClickListener!= null) {
                        onItemClickListener.onItemClick(v, position);
                    }
                }
            });
            return holder1;
        }
        if (viewType==TYPE2){
            View view= LayoutInflater.from(context).inflate(R.layout.goods_act,parent,false);
            final MyHolder2 holder2=new MyHolder2(view);
           /* view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder2.getLayoutPosition();
                    //注册点击监听
                    if (onItemClickListener!= null) {
                        onItemClickListener.onItemClick(v, position);
                    }
                }
            });*/
            return holder2;
        }
        if (viewType==TYPE3){
            View view= LayoutInflater.from(context).inflate(R.layout.goods_recommend,parent,false);
            final MyHolder3 holder3=new MyHolder3(view);
            return holder3;
        }
        if (viewType==TYPE4){
            View view= LayoutInflater.from(context).inflate(R.layout.goods_selector,parent,false);
            final MyHolder4 holder4=new MyHolder4(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder4.getLayoutPosition();
                    //注册点击监听
                    if (onItemClickListener!= null) {
                        onItemClickListener.onItemClick(v, position);
                    }
                }
            });
            return holder4;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final MyGoodsViewHolder holder, int position) {
   if (holder instanceof MyHolder0){
       ArrayList<Goods.DataBean.GoodsBean.GalleryBean> galleryBeens= (ArrayList<Goods.DataBean.GoodsBean.GalleryBean>) goods.getGoods().getGallery();
       ArrayList<String> images=new ArrayList<>();
       for (int i = 0; i <galleryBeens.size() ; i++) {
           images.add(galleryBeens.get(i).getNormal_url());
       }
       ((MyHolder0) holder).view_pager.set_img_url(images,R.drawable.selector_point);

   }
        if (holder instanceof MyHolder1){
            Goods.DataBean.GoodsBean goodsBean=goods.getGoods();
            ((MyHolder1) holder).textView_name.setText(goodsBean.getGoods_name());
            ((MyHolder1) holder).shop_pri.setText("￥"+goodsBean.getShop_price());
            ((MyHolder1) holder).market_pri.setText("￥"+goodsBean.getMarket_price());
            ((MyHolder1) holder).market_pri.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            ((MyHolder1) holder).goods_fee.setText("￥"+goodsBean.getShipping_fee());
         // ((MyHolder1) holder).goods_sale.setText(goodsBean.getSales_volume());
          //  ((MyHolder1) holder).goods_colls.setText(goodsBean.getCollect_count());
        }
        if (holder instanceof MyHolder2){
            final ArrayList<Goods.DataBean.ActivityBean> activity= (ArrayList<Goods.DataBean.ActivityBean>) goods.getActivity();
            ((MyHolder2) holder).postage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, GoodsWebView.class);
                    String url=activity.get(0).getDescription();
                    intent.putExtra("URL",url);
                    context.startActivity(intent);
                }
            });
            ((MyHolder2) holder).meet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, GoodsWebView.class);
                    String url=activity.get(1).getDescription();
                    intent.putExtra("URL",url);
                    context.startActivity(intent);
                }
            });
            ((MyHolder2) holder).tips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, GoodsWebView.class);
                    String url=activity.get(2).getDescription();
                    intent.putExtra("URL",url);
                    context.startActivity(intent);
                }
            });
        }
        if (holder instanceof MyHolder3){
           if (flag){
            ArrayList<Goods.DataBean.GoodsRelDetailsBean> detailsBeens= (ArrayList<Goods.DataBean.GoodsRelDetailsBean>) goods.getGoodsRelDetails();
            for (int i = 0; i <detailsBeens.size() ; i++) {
                LinearLayout li = (LinearLayout) View.inflate(context, R.layout.goos_tuijian, null);
                ImageView im = (ImageView) li.findViewById(R.id.goods_recom_image1);
                TextView t1 = (TextView) li.findViewById(R.id.goods_recom_name1);
                TextView t2 = (TextView) li.findViewById(R.id.goods_recom_price1);
                Glide.with(context).load(detailsBeens.get(i).getGoods_img()).placeholder(R.drawable.default_loading)
                        .error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(im);
                t1.setText(detailsBeens.get(i).getGoods_name());
                t2.setText("￥" + detailsBeens.get(i).getShop_price());
                ((MyHolder3) holder).linearLayout.addView(li);
                flag=false;
            }
            }
        }
        if (holder instanceof MyHolder4){
            if (((MyHolder4) holder).linearLayout!=null){
                ((MyHolder4) holder).linearLayout.removeAllViews();
            }
            Goods.DataBean.GoodsBean  good=goods.getGoods();
            String s=good.getGoods_desc();
            try {
                JSONArray js=new JSONArray(s);
                for (int i = 0; i <js.length() ; i++) {
                    ImageView imageView=new ImageView(context);
                    JSONObject ob= (JSONObject) js.get(i);
                    Glide.with(context).load(ob.getString("url")).placeholder(R.drawable.default_loading)
                            .error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(imageView);
                    ((MyHolder4) holder).linearLayout.addView(imageView);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

             ((MyHolder4) holder).radioButton1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     if (((MyHolder4) holder).linearLayout!=null){
                         ((MyHolder4) holder).linearLayout.removeAllViews();
                     }
                     Goods.DataBean.GoodsBean  good=goods.getGoods();
                     String s=good.getGoods_desc();
                     try {
                         JSONArray js=new JSONArray(s);
                         for (int i = 0; i <js.length() ; i++) {
                             ImageView imageView=new ImageView(context);
                             imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                             JSONObject ob= (JSONObject) js.get(i);
                             Glide.with(context).load(ob.getString("url")).placeholder(R.drawable.default_loading)
                                     .error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL)
                                     .into(imageView);
                             ((MyHolder4) holder).linearLayout.addView(imageView);
                         }
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                 }
             });
            ((MyHolder4) holder).radioButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((MyHolder4) holder).linearLayout!=null){
                        ((MyHolder4) holder).linearLayout.removeAllViews();
                    }
                    ArrayList<Goods.DataBean.GoodsBean.AttributesBean>  atts= (ArrayList<Goods.DataBean.GoodsBean.AttributesBean>) goods.getGoods().getAttributes();
                    for (int i = 0; i <atts.size() ; i++) {
                        TextView tName= new TextView(context);
                        String name=atts.get(i).getAttr_name();
                        String values=atts.get(i).getAttr_value();
                        tName.setTextSize(14);
                        if (name.length()<4){
                            name=name+" ";
                        }
                        tName.setText("   "+name+"     "+values);
                        ((MyHolder4) holder).linearLayout.addView(tName);
                    }
                }
            });
            ((MyHolder4) holder).radioButton3.setText("评论("+goods.getCommentNumber()+")");
            ((MyHolder4) holder).radioButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (((MyHolder4) holder).linearLayout!=null){
                        ((MyHolder4) holder).linearLayout.removeAllViews();
                    }
                    ArrayList<Goods.DataBean.CommentsBean> comments= (ArrayList<Goods.DataBean.CommentsBean>) goods.getComments();
                    for (int i = 0; i <comments.size() ; i++) {
                        LinearLayout lin= (LinearLayout) View.inflate(context,R.layout.goods_pinglun,null);
                        ImageView im= (ImageView) lin.findViewById(R.id.user_phone);
                        TextView name= (TextView) lin.findViewById(R.id.user_name);
                        TextView time= (TextView) lin.findViewById(R.id.user_time);
                        TextView comment= (TextView) lin.findViewById(R.id.user_comment);
                        Glide.with(context).load(comments.get(i).getUser().getIcon()).placeholder(R.drawable.default_loading)
                                .error(R.drawable.default_loading).diskCacheStrategy(DiskCacheStrategy.ALL)
                                .into(im);
                        name.setText(comments.get(i).getUser().getNick_name());
                        time.setText(comments.get(i).getCreatetime());
                        comment.setText(comments.get(i).getContent());
                        ((MyHolder4) holder).linearLayout.addView(lin);
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }


    class MyGoodsViewHolder extends RecyclerView.ViewHolder {

        public MyGoodsViewHolder(View itemView) {
            super(itemView);
        }
    }
class MyHolder0 extends MyGoodsViewHolder{
    Infinite_View_Pager view_pager;
    public MyHolder0(View itemView) {
        super(itemView);
        view_pager= (Infinite_View_Pager) itemView.findViewById(R.id.ViewPager_goods);
    }
}
        class MyHolder1 extends MyGoodsViewHolder{
            TextView textView_name;
            TextView textView_col;
             TextView shop_pri;
            TextView market_pri;
            TextView goods_fee;
           // TextView goods_sale;
           // TextView goods_colls;
            public MyHolder1(View itemView) {
                super(itemView);
                textView_name= (TextView) itemView.findViewById(R.id.goods_info_name);
                textView_col= (TextView) itemView.findViewById(R.id.goods_info_collection);
                shop_pri= (TextView) itemView.findViewById(R.id.goods_info_shop_price);
                market_pri= (TextView) itemView.findViewById(R.id.goods_info_market_price);
                goods_fee= (TextView) itemView.findViewById(R.id.goods_info_shipping_fee);
              //  goods_sale= (TextView) itemView.findViewById(R.id.goods_info_sale);
              //  goods_colls= (TextView) itemView.findViewById(R.id.goods_info_collect_count);
            }
        }
            class MyHolder2 extends MyGoodsViewHolder {
               LinearLayout postage;
                LinearLayout meet;
                LinearLayout tips;
                public MyHolder2(View itemView) {
                    super(itemView);
                    postage= (LinearLayout) itemView.findViewById(R.id.goods_postage);
                    meet= (LinearLayout) itemView.findViewById(R.id.goods_meet);
                    tips= (LinearLayout) itemView.findViewById(R.id.goods_tips);
                }
            }
                class MyHolder3 extends MyGoodsViewHolder {
                    LinearLayout linearLayout;
                    public MyHolder3(View itemView) {
                        super(itemView);
                        linearLayout= (LinearLayout) itemView.findViewById(R.id.goods_recom_linearLayout);

                    }
                }
                    class MyHolder4 extends MyGoodsViewHolder {
                        RadioButton radioButton1;
                        RadioButton radioButton2;
                        RadioButton radioButton3;
                        LinearLayout linearLayout;
                        public MyHolder4(View itemView) {
                            super(itemView);
                            radioButton1= (RadioButton) itemView.findViewById(R.id.goods_selector_item);
                            radioButton2= (RadioButton) itemView.findViewById(R.id.goods_selector_args);
                            radioButton3= (RadioButton) itemView.findViewById(R.id.goods_selector_count);
                            linearLayout= (LinearLayout) itemView.findViewById(R.id.goods_selector_linearLayout);
                        }
                    }
                }