package com.lida.shopping.bean;

import java.util.List;

/**
 * Created by WeiQingFeng on 2017/4/21.
 */

public class FragmentShopCarBean {

    private List<ContentBean> content;

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * pName : 大小咖
         * pStatus :
         * pChild : [{"cName":"美国爱尔邦尼天然儿童蜂蜜","cPrice":"288","cNumber":"1","cPic":"image"}]
         */

        private String pName;
        private boolean pEdit;
        private List<PChildBean> pChild;
        private boolean pSelect;

        public boolean ispSelect() {
            return pSelect;
        }

        public void setpSelect(boolean pSelect) {
            this.pSelect = pSelect;
        }

        public String getPName() {
            return pName;
        }

        public void setPName(String pName) {
            this.pName = pName;
        }

        public String getpName() {
            return pName;
        }

        public void setpName(String pName) {
            this.pName = pName;
        }

        public boolean ispEdit() {
            return pEdit;
        }

        public void setpEdit(boolean pEdit) {
            this.pEdit = pEdit;
        }


        public List<PChildBean> getPChild() {
            return pChild;
        }

        public void setPChild(List<PChildBean> pChild) {
            this.pChild = pChild;
        }

        public static class PChildBean {
            /**
             * cName : 美国爱尔邦尼天然儿童蜂蜜
             * cPrice : 288
             * cNumber : 1
             * cPic : image
             */

            private String cName;
            private String cPrice;
            private String cNumber;
            private int cPic;
            private boolean cEdit;
            private boolean cSelect;

            public boolean iscSelect() {
                return cSelect;
            }

            public void setcSelect(boolean cSelect) {
                this.cSelect = cSelect;
            }

            public boolean iscEdit() {
                return cEdit;
            }

            public void setcEdit(boolean cEdit) {
                this.cEdit = cEdit;
            }

            public String getCName() {
                return cName;
            }

            public void setCName(String cName) {
                this.cName = cName;
            }

            public String getCPrice() {
                return cPrice;
            }

            public void setCPrice(String cPrice) {
                this.cPrice = cPrice;
            }

            public String getCNumber() {
                return cNumber;
            }

            public void setCNumber(String cNumber) {
                this.cNumber = cNumber;
            }

            public String getcName() {
                return cName;
            }

            public void setcName(String cName) {
                this.cName = cName;
            }

            public String getcPrice() {
                return cPrice;
            }

            public void setcPrice(String cPrice) {
                this.cPrice = cPrice;
            }

            public String getcNumber() {
                return cNumber;
            }

            public void setcNumber(String cNumber) {
                this.cNumber = cNumber;
            }

            public int getcPic() {
                return cPic;
            }

            public void setcPic(int cPic) {
                this.cPic = cPic;
            }
        }
    }
}
