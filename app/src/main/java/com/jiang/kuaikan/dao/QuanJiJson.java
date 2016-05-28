package com.jiang.kuaikan.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25.
 */
public class QuanJiJson {

    /**
     * code : 200
     * data : {"comics":[{"cover_image_url":"http://i.kuaikanmanhua.com/image/160523/cfvj8nt1y.webp-w640","created_at":1463953803,"id":12443,"likes_count":264431,"status":"published","title":"第16话 小九是妖怪？","topic_id":711,"updated_at":1463932730,"url":"http://www.kuaikanmanhua.com/comics/12443"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160515/ljhlwzsh1.webp-w640","created_at":1463349003,"id":12256,"likes_count":341055,"status":"published","title":"第15话 小九不敢一个人\u2026\u2026","topic_id":711,"updated_at":1463324206,"url":"http://www.kuaikanmanhua.com/comics/12256"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160508/2wyu2h1mm.webp-w640","created_at":1462744203,"id":12059,"likes_count":365947,"status":"published","title":"第14话 小九的样子变了\u2026\u2026","topic_id":711,"updated_at":1462717875,"url":"http://www.kuaikanmanhua.com/comics/12059"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160501/vtken0ab6.webp-w640","created_at":1462139403,"id":11891,"likes_count":346524,"status":"published","title":"第13话 山里来的哥哥","topic_id":711,"updated_at":1462113527,"url":"http://www.kuaikanmanhua.com/comics/11891"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160424/nmfaf9wmx.webp-w640","created_at":1461534602,"id":11688,"likes_count":285684,"status":"published","title":"第12话 掉到老虎窝里了！","topic_id":711,"updated_at":1461507190,"url":"http://www.kuaikanmanhua.com/comics/11688"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160417/4jthblcw6.webp-w640","created_at":1460929803,"id":11502,"likes_count":285398,"status":"published","title":"第11话 最喜欢跟小孩一起出去玩～","topic_id":711,"updated_at":1460899241,"url":"http://www.kuaikanmanhua.com/comics/11502"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160411/ykfgh8l6p.webp-w640","created_at":1460344364,"id":11318,"likes_count":262465,"status":"published","title":"第10话 终于适应了学校生活","topic_id":711,"updated_at":1460340852,"url":"http://www.kuaikanmanhua.com/comics/11318"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160401/c0uwdwnpe.webp-w640","created_at":1459720203,"id":11116,"likes_count":302007,"status":"published","title":"第9话 小孩真是太难教了！","topic_id":711,"updated_at":1459510441,"url":"http://www.kuaikanmanhua.com/comics/11116"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160329/se0dim93c.webp-w640","created_at":1459288203,"id":10987,"likes_count":291484,"status":"published","title":"第8话 对不起，没有感受你的心情","topic_id":711,"updated_at":1459230567,"url":"http://www.kuaikanmanhua.com/comics/10987"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160320/192g73enf.webp-w640","created_at":1458510603,"id":10722,"likes_count":278734,"status":"published","title":"第7话 对不起让你一个人","topic_id":711,"updated_at":1458482430,"url":"http://www.kuaikanmanhua.com/comics/10722"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160313/4rvwcunpl.webp-w640","created_at":1457905802,"id":10543,"likes_count":235219,"status":"published","title":"第6话 吃货是最好对付的","topic_id":711,"updated_at":1457877831,"url":"http://www.kuaikanmanhua.com/comics/10543"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160307/5fjx63wxd.webp-w640","created_at":1457316817,"id":10346,"likes_count":236504,"status":"published","title":"第5话 小狐狸形象大改造！","topic_id":711,"updated_at":1457315940,"url":"http://www.kuaikanmanhua.com/comics/10346"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160222/110i7iuaj.webp-w640","created_at":1456091402,"id":9958,"likes_count":263111,"status":"published","title":"第4话 受不了你脏兮兮的样子了！","topic_id":711,"updated_at":1456073512,"url":"http://www.kuaikanmanhua.com/comics/9958"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160215/dd97ol18j.webp-w640","created_at":1455486602,"id":9772,"likes_count":285394,"status":"published","title":"第3话 我来抚养他吧！","topic_id":711,"updated_at":1455482750,"url":"http://www.kuaikanmanhua.com/comics/9772"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160207/ge2aky4uj.webp-w640","created_at":1454881802,"id":9567,"likes_count":295531,"status":"published","title":"第1＋2话 捡到一只很萌的狐狸？","topic_id":711,"updated_at":1454573327,"url":"http://www.kuaikanmanhua.com/comics/9567"}],"comics_count":15,"comments_count":129088,"cover_image_url":"http://i.kuaikanmanhua.com/image/160202/a3ljbucwd.webp-w640","created_at":1454393227,"description":"山里长大的小狐妖第一次进城，因种种事故被一富二代收养，不会照顾人的富二代和未经世事的小狐妖会碰撞出怎样的故事？【独家/每周一更新 责编：林早上】","discover_image_url":null,"id":711,"is_favourite":false,"label_id":23,"likes_count":4339488,"order":300,"sort":0,"title":"捡到只小狐狸","updated_at":1454393227,"user":{"avatar_url":"http://i.kuaikanmanhua.com/image/160203/sz37z2mh6.webp-w180","grade":1,"id":6957622,"nickname":"通幽/夏天岛+叨叨君/夏天岛","reg_type":"author"},"vertical_image_url":"http://i.kuaikanmanhua.com/image/160202/nf1ghze1c.webp-w320"}
     * message : OK
     */

    private int code;
    /**
     * comics : [{"cover_image_url":"http://i.kuaikanmanhua.com/image/160523/cfvj8nt1y.webp-w640","created_at":1463953803,"id":12443,"likes_count":264431,"status":"published","title":"第16话 小九是妖怪？","topic_id":711,"updated_at":1463932730,"url":"http://www.kuaikanmanhua.com/comics/12443"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160515/ljhlwzsh1.webp-w640","created_at":1463349003,"id":12256,"likes_count":341055,"status":"published","title":"第15话 小九不敢一个人\u2026\u2026","topic_id":711,"updated_at":1463324206,"url":"http://www.kuaikanmanhua.com/comics/12256"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160508/2wyu2h1mm.webp-w640","created_at":1462744203,"id":12059,"likes_count":365947,"status":"published","title":"第14话 小九的样子变了\u2026\u2026","topic_id":711,"updated_at":1462717875,"url":"http://www.kuaikanmanhua.com/comics/12059"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160501/vtken0ab6.webp-w640","created_at":1462139403,"id":11891,"likes_count":346524,"status":"published","title":"第13话 山里来的哥哥","topic_id":711,"updated_at":1462113527,"url":"http://www.kuaikanmanhua.com/comics/11891"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160424/nmfaf9wmx.webp-w640","created_at":1461534602,"id":11688,"likes_count":285684,"status":"published","title":"第12话 掉到老虎窝里了！","topic_id":711,"updated_at":1461507190,"url":"http://www.kuaikanmanhua.com/comics/11688"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160417/4jthblcw6.webp-w640","created_at":1460929803,"id":11502,"likes_count":285398,"status":"published","title":"第11话 最喜欢跟小孩一起出去玩～","topic_id":711,"updated_at":1460899241,"url":"http://www.kuaikanmanhua.com/comics/11502"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160411/ykfgh8l6p.webp-w640","created_at":1460344364,"id":11318,"likes_count":262465,"status":"published","title":"第10话 终于适应了学校生活","topic_id":711,"updated_at":1460340852,"url":"http://www.kuaikanmanhua.com/comics/11318"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160401/c0uwdwnpe.webp-w640","created_at":1459720203,"id":11116,"likes_count":302007,"status":"published","title":"第9话 小孩真是太难教了！","topic_id":711,"updated_at":1459510441,"url":"http://www.kuaikanmanhua.com/comics/11116"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160329/se0dim93c.webp-w640","created_at":1459288203,"id":10987,"likes_count":291484,"status":"published","title":"第8话 对不起，没有感受你的心情","topic_id":711,"updated_at":1459230567,"url":"http://www.kuaikanmanhua.com/comics/10987"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160320/192g73enf.webp-w640","created_at":1458510603,"id":10722,"likes_count":278734,"status":"published","title":"第7话 对不起让你一个人","topic_id":711,"updated_at":1458482430,"url":"http://www.kuaikanmanhua.com/comics/10722"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160313/4rvwcunpl.webp-w640","created_at":1457905802,"id":10543,"likes_count":235219,"status":"published","title":"第6话 吃货是最好对付的","topic_id":711,"updated_at":1457877831,"url":"http://www.kuaikanmanhua.com/comics/10543"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160307/5fjx63wxd.webp-w640","created_at":1457316817,"id":10346,"likes_count":236504,"status":"published","title":"第5话 小狐狸形象大改造！","topic_id":711,"updated_at":1457315940,"url":"http://www.kuaikanmanhua.com/comics/10346"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160222/110i7iuaj.webp-w640","created_at":1456091402,"id":9958,"likes_count":263111,"status":"published","title":"第4话 受不了你脏兮兮的样子了！","topic_id":711,"updated_at":1456073512,"url":"http://www.kuaikanmanhua.com/comics/9958"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160215/dd97ol18j.webp-w640","created_at":1455486602,"id":9772,"likes_count":285394,"status":"published","title":"第3话 我来抚养他吧！","topic_id":711,"updated_at":1455482750,"url":"http://www.kuaikanmanhua.com/comics/9772"},{"cover_image_url":"http://i.kuaikanmanhua.com/image/160207/ge2aky4uj.webp-w640","created_at":1454881802,"id":9567,"likes_count":295531,"status":"published","title":"第1＋2话 捡到一只很萌的狐狸？","topic_id":711,"updated_at":1454573327,"url":"http://www.kuaikanmanhua.com/comics/9567"}]
     * comics_count : 15
     * comments_count : 129088
     * cover_image_url : http://i.kuaikanmanhua.com/image/160202/a3ljbucwd.webp-w640
     * created_at : 1454393227
     * description : 山里长大的小狐妖第一次进城，因种种事故被一富二代收养，不会照顾人的富二代和未经世事的小狐妖会碰撞出怎样的故事？【独家/每周一更新 责编：林早上】
     * discover_image_url : null
     * id : 711
     * is_favourite : false
     * label_id : 23
     * likes_count : 4339488
     * order : 300
     * sort : 0
     * title : 捡到只小狐狸
     * updated_at : 1454393227
     * user : {"avatar_url":"http://i.kuaikanmanhua.com/image/160203/sz37z2mh6.webp-w180","grade":1,"id":6957622,"nickname":"通幽/夏天岛+叨叨君/夏天岛","reg_type":"author"}
     * vertical_image_url : http://i.kuaikanmanhua.com/image/160202/nf1ghze1c.webp-w320
     */

    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean implements Serializable {
        private int comics_count;
        private int comments_count;
        private String cover_image_url;
        private int created_at;
        private String description;
        private Object discover_image_url;
        private int id;
        private boolean is_favourite;
        private int label_id;
        private int likes_count;
        private int order;
        private int sort;
        private String title;
        private int updated_at;
        /**
         * avatar_url : http://i.kuaikanmanhua.com/image/160203/sz37z2mh6.webp-w180
         * grade : 1
         * id : 6957622
         * nickname : 通幽/夏天岛+叨叨君/夏天岛
         * reg_type : author
         */

        private UserBean user;
        private String vertical_image_url;
        /**
         * cover_image_url : http://i.kuaikanmanhua.com/image/160523/cfvj8nt1y.webp-w640
         * created_at : 1463953803
         * id : 12443
         * likes_count : 264431
         * status : published
         * title : 第16话 小九是妖怪？
         * topic_id : 711
         * updated_at : 1463932730
         * url : http://www.kuaikanmanhua.com/comics/12443
         */

        private List<ComicsBean> comics;

        public int getComics_count() {
            return comics_count;
        }

        public void setComics_count(int comics_count) {
            this.comics_count = comics_count;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getCover_image_url() {
            return cover_image_url;
        }

        public void setCover_image_url(String cover_image_url) {
            this.cover_image_url = cover_image_url;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getDiscover_image_url() {
            return discover_image_url;
        }

        public void setDiscover_image_url(Object discover_image_url) {
            this.discover_image_url = discover_image_url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isIs_favourite() {
            return is_favourite;
        }

        public void setIs_favourite(boolean is_favourite) {
            this.is_favourite = is_favourite;
        }

        public int getLabel_id() {
            return label_id;
        }

        public void setLabel_id(int label_id) {
            this.label_id = label_id;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVertical_image_url() {
            return vertical_image_url;
        }

        public void setVertical_image_url(String vertical_image_url) {
            this.vertical_image_url = vertical_image_url;
        }

        public List<ComicsBean> getComics() {
            return comics;
        }

        public void setComics(List<ComicsBean> comics) {
            this.comics = comics;
        }

        public static class UserBean implements Serializable {
            private String avatar_url;
            private int grade;
            private int id;
            private String nickname;
            private String reg_type;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getReg_type() {
                return reg_type;
            }

            public void setReg_type(String reg_type) {
                this.reg_type = reg_type;
            }
        }

        public static class ComicsBean implements Serializable {
            private String cover_image_url;
            private int created_at;
            private int id;
            private int likes_count;
            private String status;
            private String title;
            private int topic_id;
            private int updated_at;
            private String url;

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getTopic_id() {
                return topic_id;
            }

            public void setTopic_id(int topic_id) {
                this.topic_id = topic_id;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
