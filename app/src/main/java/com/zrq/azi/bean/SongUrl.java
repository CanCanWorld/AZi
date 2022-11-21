package com.zrq.azi.bean;

import androidx.annotation.Keep;

import java.util.List;

@Keep
public class SongUrl {

    private List<DataBean> data;
    private long code;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public static class DataBean {
        private long id;
        private String url;
        private long br;
        private long size;
        private String md5;
        private long code;
        private long expi;
        private String type;
        private double gain;
        private long fee;
        private Object uf;
        private long payed;
        private long flag;
        private boolean canExtend;
        private Object freeTrialInfo;
        private Object level;
        private Object encodeType;
        private Object freeTrialPrivilege;
        private FreeTimeTrialPrivilegeBean freeTimeTrialPrivilege;
        private long urlSource;
        private long rightSource;
        private String podcastCtrp;
        private Object effectTypes;
        private long time;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getBr() {
            return br;
        }

        public void setBr(long br) {
            this.br = br;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public long getCode() {
            return code;
        }

        public void setCode(long code) {
            this.code = code;
        }

        public long getExpi() {
            return expi;
        }

        public void setExpi(long expi) {
            this.expi = expi;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getGain() {
            return gain;
        }

        public void setGain(double gain) {
            this.gain = gain;
        }

        public long getFee() {
            return fee;
        }

        public void setFee(long fee) {
            this.fee = fee;
        }

        public Object getUf() {
            return uf;
        }

        public void setUf(Object uf) {
            this.uf = uf;
        }

        public long getPayed() {
            return payed;
        }

        public void setPayed(long payed) {
            this.payed = payed;
        }

        public long getFlag() {
            return flag;
        }

        public void setFlag(long flag) {
            this.flag = flag;
        }

        public boolean isCanExtend() {
            return canExtend;
        }

        public void setCanExtend(boolean canExtend) {
            this.canExtend = canExtend;
        }

        public Object getFreeTrialInfo() {
            return freeTrialInfo;
        }

        public void setFreeTrialInfo(Object freeTrialInfo) {
            this.freeTrialInfo = freeTrialInfo;
        }

        public Object getLevel() {
            return level;
        }

        public void setLevel(Object level) {
            this.level = level;
        }

        public Object getEncodeType() {
            return encodeType;
        }

        public void setEncodeType(Object encodeType) {
            this.encodeType = encodeType;
        }

        public Object getFreeTrialPrivilege() {
            return freeTrialPrivilege;
        }

        public void setFreeTrialPrivilege(Object freeTrialPrivilege) {
            this.freeTrialPrivilege = freeTrialPrivilege;
        }

        public FreeTimeTrialPrivilegeBean getFreeTimeTrialPrivilege() {
            return freeTimeTrialPrivilege;
        }

        public void setFreeTimeTrialPrivilege(FreeTimeTrialPrivilegeBean freeTimeTrialPrivilege) {
            this.freeTimeTrialPrivilege = freeTimeTrialPrivilege;
        }

        public long getUrlSource() {
            return urlSource;
        }

        public void setUrlSource(long urlSource) {
            this.urlSource = urlSource;
        }

        public long getRightSource() {
            return rightSource;
        }

        public void setRightSource(long rightSource) {
            this.rightSource = rightSource;
        }

        public String getPodcastCtrp() {
            return podcastCtrp;
        }

        public void setPodcastCtrp(String podcastCtrp) {
            this.podcastCtrp = podcastCtrp;
        }

        public Object getEffectTypes() {
            return effectTypes;
        }

        public void setEffectTypes(Object effectTypes) {
            this.effectTypes = effectTypes;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public static class FreeTimeTrialPrivilegeBean {
            private boolean resConsumable;
            private boolean userConsumable;
            private long type;
            private long remalongime;

            public boolean isResConsumable() {
                return resConsumable;
            }

            public void setResConsumable(boolean resConsumable) {
                this.resConsumable = resConsumable;
            }

            public boolean isUserConsumable() {
                return userConsumable;
            }

            public void setUserConsumable(boolean userConsumable) {
                this.userConsumable = userConsumable;
            }

            public long getType() {
                return type;
            }

            public void setType(long type) {
                this.type = type;
            }

            public long getRemalongime() {
                return remalongime;
            }

            public void setRemalongime(long remalongime) {
                this.remalongime = remalongime;
            }
        }
    }
}
