package com.bawei.tianshuo.yunifang.bean;

import java.util.List;

/**
 * 类的用途：
 * author: 田硕
 * date:2017/4/18
 */

public class ClassItemBean {

    /**
     * code : 200
     * msg : success
     * data : [{"id":"772","goods_name":"清爽亮颜黑面膜套装21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/772/goods_img/1608191429278479187604212.jpg","sales_volume":51753,"efficacy":"热销黑膜 净透亮肤","sort":0},{"id":"446","goods_name":"芦荟补水保湿凝胶150g","shop_price":49.9,"market_price":59,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/446/goods_img/16081909409518953549635059.jpg","sales_volume":38807,"efficacy":"水水润润 修护受损","sort":0},{"id":"14","goods_name":"矿物泥浆鼻膜60g","shop_price":55,"market_price":69,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/14/goods_img/160819084841216186223194195.jpg","sales_volume":32407,"efficacy":"草莓鼻小救星 收敛毛孔","sort":0},{"id":"11","goods_name":"热销爆款丨清爽平衡矿物泥浆面膜260g","shop_price":99,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/11/goods_img/16081908468057836605117116.jpg","sales_volume":25904,"efficacy":"口碑泥浆 清爽控油","sort":0},{"id":"428","goods_name":"多彩水润亮颜蚕丝面膜套装21片","shop_price":79.9,"market_price":270.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/428/goods_img/160819094034113421009937866.jpg","sales_volume":23968,"efficacy":"吸黑焕彩 补水保湿","sort":0},{"id":"97","goods_name":"男士黑茶控油矿物洁面乳100ml","shop_price":39.9,"market_price":59,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/97/goods_img/160819085859519379473858091.jpg","sales_volume":23698,"efficacy":"深层清洁 收缩毛孔","sort":0},{"id":"559","goods_name":"热销泥浆丨竹炭净透矿物泥浆面膜110g","shop_price":59,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/559/goods_img/16081909445727749257882094.jpg","sales_volume":22173,"efficacy":"控油净肤 细腻毛孔","sort":0},{"id":"3","goods_name":"清爽平衡矿物洁面乳100ml","shop_price":26.9,"market_price":29.9,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/3/goods_img/160819084315017845139127816.jpg","sales_volume":22098,"efficacy":"深层清洁 平衡水油","sort":0},{"id":"189","goods_name":"热销套装丨清爽平衡护肤三件套","shop_price":99.9,"market_price":179.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/189/goods_img/160819091183119066095185335.jpg","sales_volume":20906,"efficacy":"深层清洁 平衡水油","sort":0},{"id":"593","goods_name":"热销黑膜丨葡萄籽琉璃亮颜黑面膜21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/593/goods_img/1608190945359698973439364.jpg","sales_volume":18381,"efficacy":"葡萄鲜饮 净透亮肤","sort":0},{"id":"20","goods_name":"清润紧致蚕丝面膜套装21片","shop_price":109.9,"market_price":307,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/20/goods_img/160819084923710469247382812.jpg","sales_volume":15568,"efficacy":"清透滋养 弹嫩紧致","sort":0},{"id":"313","goods_name":"清爽平衡矿物爽肤水150ml","shop_price":65,"market_price":69,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/313/goods_img/160819092628116143728778105.jpg","sales_volume":13894,"efficacy":"补水控油 收敛毛孔","sort":0},{"id":"646","goods_name":"黑茶水滢净润黑面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/646/goods_img/160819142886610735083339639.jpg","sales_volume":13152,"efficacy":"深层精华 改善暗沉","sort":0},{"id":"17","goods_name":"礼盒装丨男士黑茶控油护肤三件套","shop_price":99.9,"market_price":199.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/17/goods_img/16081908499853298911775471.jpg","sales_volume":12167,"efficacy":"清洁控油 神清气爽","sort":0},{"id":"1249","goods_name":"口碑推荐|盈透柔肤黑膜组合装42片","shop_price":199.9,"market_price":594,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1249/goods_img/170104100411616941119547437.jpg","sales_volume":8863,"efficacy":"清洁补水 保湿提亮","sort":0},{"id":"141","goods_name":"清爽平衡矿物睡眠面膜180g","shop_price":69.9,"market_price":79.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/141/goods_img/160819090489317926014897812.jpg","sales_volume":7368,"efficacy":"平衡水油 清爽净透","sort":0},{"id":"622","goods_name":"葡萄籽琉璃亮颜黑面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/622/goods_img/160819094698413173347474163.jpg","sales_volume":6201,"efficacy":"葡萄鲜饮 净透亮肤","sort":0},{"id":"139","goods_name":"芦荟矿物睡眠面膜180g","shop_price":99,"market_price":129,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/139/goods_img/16081909049706137637561178.jpg","sales_volume":6072,"efficacy":"淡化痘印 舒爽无痕","sort":0},{"id":"61","goods_name":"男士黑茶控油保湿二件套装 洁面乳保湿露","shop_price":69.9,"market_price":129.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/61/goods_img/160819085159614243649094666.jpg","sales_volume":5696,"efficacy":"控油保湿 清爽洁净","sort":0},{"id":"13","goods_name":"芦荟泥浆面膜110g","shop_price":69,"market_price":79,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/13/goods_img/16083021124081202108009565.jpg","sales_volume":5378,"efficacy":"休止痘痘 平滑肌肤","sort":0},{"id":"77","goods_name":"薰衣草矿物洁面乳100ml","shop_price":35,"market_price":39,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/77/goods_img/16081908542112823857485059.jpg","sales_volume":4762,"efficacy":"温和清洁 舒缓修护","sort":0},{"id":"163","goods_name":"清爽平衡矿物蚕丝面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/163/goods_img/160819090788311035481315778.jpg","sales_volume":4757,"efficacy":"补水控油 清爽保湿","sort":0},{"id":"341","goods_name":"清爽平衡矿物爽肤乳液120ml","shop_price":79,"market_price":89,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/341/goods_img/16081909295829444526554550.jpg","sales_volume":4744,"efficacy":"补水保湿 清爽控油","sort":0},{"id":"868","goods_name":"男士黑茶清爽矿物面膜  今日买5片送5片","shop_price":49.9,"market_price":150,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/868/goods_img/1608191430564693145258305.jpg","sales_volume":4181,"efficacy":"洁净控油 强劲清爽","sort":0},{"id":"534","goods_name":"净透美白矿物蚕丝面膜套装28片","shop_price":139.9,"market_price":396,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/534/goods_img/160819094245115265661305031.jpg","sales_volume":3955,"efficacy":"清洁净透 以白养白","sort":0},{"id":"1251","goods_name":"水果缤纷面膜超值装35片","shop_price":169.9,"market_price":495,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1251/goods_img/170104095895513706519167911.jpg","sales_volume":3925,"efficacy":"清洁控油 补水提亮","sort":0},{"id":"1638","goods_name":"嫩肌酵素黑膜礼盒21片","shop_price":139.9,"market_price":299,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/1638/goods_img/17030210211762506087062132.jpg","sales_volume":3729,"efficacy":"鲜果酵素 弹嫩水润","sort":0},{"id":"598","goods_name":"男士黑茶清爽控油矿物泥浆面膜260g","shop_price":69,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/598/goods_img/16081909464842878902279307.jpg","sales_volume":3694,"efficacy":"清洁控油 保湿收毛孔","sort":0},{"id":"920","goods_name":"法国珍珠藻清透面膜5片","shop_price":59.9,"market_price":79,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/920/goods_img/16081217454451202108002265.jpg","sales_volume":3573,"efficacy":"平衡水油 净彻亮肤","sort":0},{"id":"1280","goods_name":"新品上市|御泥坊精华水分光感气垫BB霜","shop_price":139,"market_price":169,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1280/goods_img/16120518307098199689667991.jpg","sales_volume":2961,"efficacy":"控油遮瑕 水润透亮","sort":0}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 772
         * goods_name : 清爽亮颜黑面膜套装21片
         * shop_price : 99.9
         * market_price : 297.0
         * is_coupon_allowed : true
         * is_allow_credit : false
         * goods_img : http://image.hmeili.com/yunifang/images/goods/772/goods_img/1608191429278479187604212.jpg
         * sales_volume : 51753
         * efficacy : 热销黑膜 净透亮肤
         * sort : 0
         */

        private String id;
        private String goods_name;
        private double shop_price;
        private double market_price;
        private boolean is_coupon_allowed;
        private boolean is_allow_credit;
        private String goods_img;
        private int sales_volume;
        private String efficacy;
        private int sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public double getShop_price() {
            return shop_price;
        }

        public void setShop_price(double shop_price) {
            this.shop_price = shop_price;
        }

        public double getMarket_price() {
            return market_price;
        }

        public void setMarket_price(double market_price) {
            this.market_price = market_price;
        }

        public boolean isIs_coupon_allowed() {
            return is_coupon_allowed;
        }

        public void setIs_coupon_allowed(boolean is_coupon_allowed) {
            this.is_coupon_allowed = is_coupon_allowed;
        }

        public boolean isIs_allow_credit() {
            return is_allow_credit;
        }

        public void setIs_allow_credit(boolean is_allow_credit) {
            this.is_allow_credit = is_allow_credit;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public int getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(int sales_volume) {
            this.sales_volume = sales_volume;
        }

        public String getEfficacy() {
            return efficacy;
        }

        public void setEfficacy(String efficacy) {
            this.efficacy = efficacy;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
