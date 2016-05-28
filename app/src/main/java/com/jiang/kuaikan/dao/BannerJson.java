package com.jiang.kuaikan.dao;

import java.util.List;

/**
 * Created by Administrator on 2016/5/27.
 */
public class BannerJson {

    /**
     * code : 200
     * data : {"banner_group":[{"pic":"http://i.kuaikanmanhua.com/image/160522/fzf7gatqm.webp-w640","title":"","type":3,"value":"12365"},{"pic":"http://i.kuaikanmanhua.com/image/160522/12222m1ne.webp-w640","title":"","type":3,"value":"12134"},{"pic":"http://i.kuaikanmanhua.com/image/160524/042c8lebt.webp-w640","title":"","type":3,"value":"11762"},{"pic":"http://i.kuaikanmanhua.com/image/160524/fg0curw32.webp-w640","title":"","type":3,"value":"11770"},{"pic":"http://i.kuaikanmanhua.com/image/160524/5w84c1xlo.webp-w640","title":"","type":3,"value":"12145"}]}
     * message : OK
     */

    private int code;
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

    public static class DataBean {
        /**
         * pic : http://i.kuaikanmanhua.com/image/160522/fzf7gatqm.webp-w640
         * title :
         * type : 3
         * value : 12365
         */

        private List<BannerGroupBean> banner_group;

        public List<BannerGroupBean> getBanner_group() {
            return banner_group;
        }

        public void setBanner_group(List<BannerGroupBean> banner_group) {
            this.banner_group = banner_group;
        }

        public static class BannerGroupBean {
            private String pic;
            private String title;
            private int type;
            private String value;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
