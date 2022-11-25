package com.zrq.azi.bean;

import java.util.List;

public class DailySongs {

    private int code;
    private DataDTO data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        private List<DailySongsDTO> dailySongs;
        private List<?> orderSongs;
        private List<RecommendReasonsDTO> recommendReasons;

        public List<DailySongsDTO> getDailySongs() {
            return dailySongs;
        }

        public void setDailySongs(List<DailySongsDTO> dailySongs) {
            this.dailySongs = dailySongs;
        }

        public List<?> getOrderSongs() {
            return orderSongs;
        }

        public void setOrderSongs(List<?> orderSongs) {
            this.orderSongs = orderSongs;
        }

        public List<RecommendReasonsDTO> getRecommendReasons() {
            return recommendReasons;
        }

        public void setRecommendReasons(List<RecommendReasonsDTO> recommendReasons) {
            this.recommendReasons = recommendReasons;
        }

        public static class DailySongsDTO {
            private String name;
            private String singer;
            private long id;
            private long pst;
            private long t;
            private List<ArDTO> ar;
            private List<?> alia;
            private long pop;
            private long st;
            private String rt;
            private long fee;
            private long v;
            private Object crbt;
            private String cf;
            private AlDTO al;
            private long dt;
            private HDTO h;
            private Object m;
            private LDTO l;
            private SqDTO sq;
            private Object hr;
            private Object a;
            private String cd;
            private long no;
            private Object rtUrl;
            private long ftype;
            private List<?> rtUrls;
            private long djId;
            private long copyright;
            private long s_id;
            private long mark;
            private long originCoverType;
            private Object originSongSimpleData;
            private Object tagPicList;
            private boolean resourceState;
            private long version;
            private Object songJumpInfo;
            private Object entertainmentTags;
            private long single;
            private Object noCopyrightRcmd;
            private long rtype;
            private Object rurl;
            private long mst;
            private long cp;
            private long mv;
            private long publishTime;
            private String reason;
            private PrivilegeDTO privilege;
            private String alg;
            private List<String> tns;
            private String s_ctrp;

            public void setSinger(String singer) {
                this.singer = singer;
            }

            public String getSinger() {
                return singer;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public long getPst() {
                return pst;
            }

            public void setPst(long pst) {
                this.pst = pst;
            }

            public long getT() {
                return t;
            }

            public void setT(long t) {
                this.t = t;
            }

            public List<ArDTO> getAr() {
                return ar;
            }

            public void setAr(List<ArDTO> ar) {
                this.ar = ar;
            }

            public List<?> getAlia() {
                return alia;
            }

            public void setAlia(List<?> alia) {
                this.alia = alia;
            }

            public long getPop() {
                return pop;
            }

            public void setPop(long pop) {
                this.pop = pop;
            }

            public long getSt() {
                return st;
            }

            public void setSt(long st) {
                this.st = st;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public long getFee() {
                return fee;
            }

            public void setFee(long fee) {
                this.fee = fee;
            }

            public long getV() {
                return v;
            }

            public void setV(long v) {
                this.v = v;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public String getCf() {
                return cf;
            }

            public void setCf(String cf) {
                this.cf = cf;
            }

            public AlDTO getAl() {
                return al;
            }

            public void setAl(AlDTO al) {
                this.al = al;
            }

            public long getDt() {
                return dt;
            }

            public void setDt(long dt) {
                this.dt = dt;
            }

            public HDTO getH() {
                return h;
            }

            public void setH(HDTO h) {
                this.h = h;
            }

            public Object getM() {
                return m;
            }

            public void setM(Object m) {
                this.m = m;
            }

            public LDTO getL() {
                return l;
            }

            public void setL(LDTO l) {
                this.l = l;
            }

            public SqDTO getSq() {
                return sq;
            }

            public void setSq(SqDTO sq) {
                this.sq = sq;
            }

            public Object getHr() {
                return hr;
            }

            public void setHr(Object hr) {
                this.hr = hr;
            }

            public Object getA() {
                return a;
            }

            public void setA(Object a) {
                this.a = a;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public long getNo() {
                return no;
            }

            public void setNo(long no) {
                this.no = no;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public long getFtype() {
                return ftype;
            }

            public void setFtype(long ftype) {
                this.ftype = ftype;
            }

            public List<?> getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            public long getDjId() {
                return djId;
            }

            public void setDjId(long djId) {
                this.djId = djId;
            }

            public long getCopyright() {
                return copyright;
            }

            public void setCopyright(long copyright) {
                this.copyright = copyright;
            }

            public long getS_id() {
                return s_id;
            }

            public void setS_id(long s_id) {
                this.s_id = s_id;
            }

            public long getMark() {
                return mark;
            }

            public void setMark(long mark) {
                this.mark = mark;
            }

            public long getOriginCoverType() {
                return originCoverType;
            }

            public void setOriginCoverType(long originCoverType) {
                this.originCoverType = originCoverType;
            }

            public Object getOriginSongSimpleData() {
                return originSongSimpleData;
            }

            public void setOriginSongSimpleData(Object originSongSimpleData) {
                this.originSongSimpleData = originSongSimpleData;
            }

            public Object getTagPicList() {
                return tagPicList;
            }

            public void setTagPicList(Object tagPicList) {
                this.tagPicList = tagPicList;
            }

            public boolean isResourceState() {
                return resourceState;
            }

            public void setResourceState(boolean resourceState) {
                this.resourceState = resourceState;
            }

            public long getVersion() {
                return version;
            }

            public void setVersion(long version) {
                this.version = version;
            }

            public Object getSongJumpInfo() {
                return songJumpInfo;
            }

            public void setSongJumpInfo(Object songJumpInfo) {
                this.songJumpInfo = songJumpInfo;
            }

            public Object getEntertainmentTags() {
                return entertainmentTags;
            }

            public void setEntertainmentTags(Object entertainmentTags) {
                this.entertainmentTags = entertainmentTags;
            }

            public long getSingle() {
                return single;
            }

            public void setSingle(long single) {
                this.single = single;
            }

            public Object getNoCopyrightRcmd() {
                return noCopyrightRcmd;
            }

            public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
                this.noCopyrightRcmd = noCopyrightRcmd;
            }

            public long getRtype() {
                return rtype;
            }

            public void setRtype(long rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public long getMst() {
                return mst;
            }

            public void setMst(long mst) {
                this.mst = mst;
            }

            public long getCp() {
                return cp;
            }

            public void setCp(long cp) {
                this.cp = cp;
            }

            public long getMv() {
                return mv;
            }

            public void setMv(long mv) {
                this.mv = mv;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public PrivilegeDTO getPrivilege() {
                return privilege;
            }

            public void setPrivilege(PrivilegeDTO privilege) {
                this.privilege = privilege;
            }

            public String getAlg() {
                return alg;
            }

            public void setAlg(String alg) {
                this.alg = alg;
            }

            public List<String> getTns() {
                return tns;
            }

            public void setTns(List<String> tns) {
                this.tns = tns;
            }

            public String getS_ctrp() {
                return s_ctrp;
            }

            public void setS_ctrp(String s_ctrp) {
                this.s_ctrp = s_ctrp;
            }

            public static class AlDTO {
                private long id;
                private String name;
                private String picUrl;
                private List<?> tns;
                private String pic_str;
                private long pic;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }

                public String getPic_str() {
                    return pic_str;
                }

                public void setPic_str(String pic_str) {
                    this.pic_str = pic_str;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }
            }

            public static class HDTO {
                private long br;
                private long fid;
                private long size;
                private long vd;
                private long sr;

                public long getBr() {
                    return br;
                }

                public void setBr(long br) {
                    this.br = br;
                }

                public long getFid() {
                    return fid;
                }

                public void setFid(long fid) {
                    this.fid = fid;
                }

                public long getSize() {
                    return size;
                }

                public void setSize(long size) {
                    this.size = size;
                }

                public long getVd() {
                    return vd;
                }

                public void setVd(long vd) {
                    this.vd = vd;
                }

                public long getSr() {
                    return sr;
                }

                public void setSr(long sr) {
                    this.sr = sr;
                }
            }

            public static class LDTO {
                private long br;
                private long fid;
                private long size;
                private long vd;
                private long sr;

                public long getBr() {
                    return br;
                }

                public void setBr(long br) {
                    this.br = br;
                }

                public long getFid() {
                    return fid;
                }

                public void setFid(long fid) {
                    this.fid = fid;
                }

                public long getSize() {
                    return size;
                }

                public void setSize(long size) {
                    this.size = size;
                }

                public long getVd() {
                    return vd;
                }

                public void setVd(long vd) {
                    this.vd = vd;
                }

                public long getSr() {
                    return sr;
                }

                public void setSr(long sr) {
                    this.sr = sr;
                }
            }

            public static class SqDTO {
                private long br;
                private long fid;
                private long size;
                private long vd;
                private long sr;

                public long getBr() {
                    return br;
                }

                public void setBr(long br) {
                    this.br = br;
                }

                public long getFid() {
                    return fid;
                }

                public void setFid(long fid) {
                    this.fid = fid;
                }

                public long getSize() {
                    return size;
                }

                public void setSize(long size) {
                    this.size = size;
                }

                public long getVd() {
                    return vd;
                }

                public void setVd(long vd) {
                    this.vd = vd;
                }

                public long getSr() {
                    return sr;
                }

                public void setSr(long sr) {
                    this.sr = sr;
                }
            }

            public static class PrivilegeDTO {
                private long id;
                private long fee;
                private long payed;
                private long st;
                private long pl;
                private long dl;
                private long sp;
                private long cp;
                private long subp;
                private boolean cs;
                private long maxbr;
                private long fl;
                private boolean toast;
                private long flag;
                private boolean preSell;
                private long playMaxbr;
                private long downloadMaxbr;
                private String maxBrLevel;
                private String playMaxBrLevel;
                private String downloadMaxBrLevel;
                private String plLevel;
                private String dlLevel;
                private String flLevel;
                private Object rscl;
                private FreeTrialPrivilegeDTO freeTrialPrivilege;
                private List<ChargeInfoListDTO> chargeInfoList;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public long getFee() {
                    return fee;
                }

                public void setFee(long fee) {
                    this.fee = fee;
                }

                public long getPayed() {
                    return payed;
                }

                public void setPayed(long payed) {
                    this.payed = payed;
                }

                public long getSt() {
                    return st;
                }

                public void setSt(long st) {
                    this.st = st;
                }

                public long getPl() {
                    return pl;
                }

                public void setPl(long pl) {
                    this.pl = pl;
                }

                public long getDl() {
                    return dl;
                }

                public void setDl(long dl) {
                    this.dl = dl;
                }

                public long getSp() {
                    return sp;
                }

                public void setSp(long sp) {
                    this.sp = sp;
                }

                public long getCp() {
                    return cp;
                }

                public void setCp(long cp) {
                    this.cp = cp;
                }

                public long getSubp() {
                    return subp;
                }

                public void setSubp(long subp) {
                    this.subp = subp;
                }

                public boolean isCs() {
                    return cs;
                }

                public void setCs(boolean cs) {
                    this.cs = cs;
                }

                public long getMaxbr() {
                    return maxbr;
                }

                public void setMaxbr(long maxbr) {
                    this.maxbr = maxbr;
                }

                public long getFl() {
                    return fl;
                }

                public void setFl(long fl) {
                    this.fl = fl;
                }

                public boolean isToast() {
                    return toast;
                }

                public void setToast(boolean toast) {
                    this.toast = toast;
                }

                public long getFlag() {
                    return flag;
                }

                public void setFlag(long flag) {
                    this.flag = flag;
                }

                public boolean isPreSell() {
                    return preSell;
                }

                public void setPreSell(boolean preSell) {
                    this.preSell = preSell;
                }

                public long getPlayMaxbr() {
                    return playMaxbr;
                }

                public void setPlayMaxbr(long playMaxbr) {
                    this.playMaxbr = playMaxbr;
                }

                public long getDownloadMaxbr() {
                    return downloadMaxbr;
                }

                public void setDownloadMaxbr(long downloadMaxbr) {
                    this.downloadMaxbr = downloadMaxbr;
                }

                public String getMaxBrLevel() {
                    return maxBrLevel;
                }

                public void setMaxBrLevel(String maxBrLevel) {
                    this.maxBrLevel = maxBrLevel;
                }

                public String getPlayMaxBrLevel() {
                    return playMaxBrLevel;
                }

                public void setPlayMaxBrLevel(String playMaxBrLevel) {
                    this.playMaxBrLevel = playMaxBrLevel;
                }

                public String getDownloadMaxBrLevel() {
                    return downloadMaxBrLevel;
                }

                public void setDownloadMaxBrLevel(String downloadMaxBrLevel) {
                    this.downloadMaxBrLevel = downloadMaxBrLevel;
                }

                public String getPlLevel() {
                    return plLevel;
                }

                public void setPlLevel(String plLevel) {
                    this.plLevel = plLevel;
                }

                public String getDlLevel() {
                    return dlLevel;
                }

                public void setDlLevel(String dlLevel) {
                    this.dlLevel = dlLevel;
                }

                public String getFlLevel() {
                    return flLevel;
                }

                public void setFlLevel(String flLevel) {
                    this.flLevel = flLevel;
                }

                public Object getRscl() {
                    return rscl;
                }

                public void setRscl(Object rscl) {
                    this.rscl = rscl;
                }

                public FreeTrialPrivilegeDTO getFreeTrialPrivilege() {
                    return freeTrialPrivilege;
                }

                public void setFreeTrialPrivilege(FreeTrialPrivilegeDTO freeTrialPrivilege) {
                    this.freeTrialPrivilege = freeTrialPrivilege;
                }

                public List<ChargeInfoListDTO> getChargeInfoList() {
                    return chargeInfoList;
                }

                public void setChargeInfoList(List<ChargeInfoListDTO> chargeInfoList) {
                    this.chargeInfoList = chargeInfoList;
                }

                public static class FreeTrialPrivilegeDTO {
                    private boolean resConsumable;
                    private boolean userConsumable;
                    private long listenType;

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

                    public long getListenType() {
                        return listenType;
                    }

                    public void setListenType(long listenType) {
                        this.listenType = listenType;
                    }
                }

                public static class ChargeInfoListDTO {
                    private long rate;
                    private Object chargeUrl;
                    private Object chargeMessage;
                    private long chargeType;

                    public long getRate() {
                        return rate;
                    }

                    public void setRate(long rate) {
                        this.rate = rate;
                    }

                    public Object getChargeUrl() {
                        return chargeUrl;
                    }

                    public void setChargeUrl(Object chargeUrl) {
                        this.chargeUrl = chargeUrl;
                    }

                    public Object getChargeMessage() {
                        return chargeMessage;
                    }

                    public void setChargeMessage(Object chargeMessage) {
                        this.chargeMessage = chargeMessage;
                    }

                    public long getChargeType() {
                        return chargeType;
                    }

                    public void setChargeType(long chargeType) {
                        this.chargeType = chargeType;
                    }
                }
            }

            public static class ArDTO {
                private long id;
                private String name;
                private List<?> tns;
                private List<?> alias;

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class RecommendReasonsDTO {
            private long songId;
            private String reason;
            private String reasonId;
            private Object targetUrl;

            public long getSongId() {
                return songId;
            }

            public void setSongId(long songId) {
                this.songId = songId;
            }

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getReasonId() {
                return reasonId;
            }

            public void setReasonId(String reasonId) {
                this.reasonId = reasonId;
            }

            public Object getTargetUrl() {
                return targetUrl;
            }

            public void setTargetUrl(Object targetUrl) {
                this.targetUrl = targetUrl;
            }
        }
    }
}
