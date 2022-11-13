package com.zrq.azi.bean;

import java.util.List;

public class Dj {

    private int count;
    private int code;
    private List<ProgramsBean> programs;
    private boolean more;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ProgramsBean> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramsBean> programs) {
        this.programs = programs;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public static class ProgramsBean {
        private MainSongBean mainSong;
        private Object songs;
        private DjBean dj;
        private String blurCoverUrl;
        private RadioBean radio;
        private int duration;
        private Object authDTO;
        private boolean buyed;
        private Object programDesc;
        private Object h5Links;
        private boolean canReward;
        private int auditStatus;
        private Object videoInfo;
        private int score;
        private Object liveInfo;
        private Object alg;
        private Object disPlayStatus;
        private int auditDisPlayStatus;
        private Object categoryName;
        private Object secondCategoryName;
        private boolean existLyric;
        private Object djPlayRecordVo;
        private boolean recommended;
        private Object icon;
        private Object adIconInfo;
        private boolean isPublish;
        private int trackCount;
        private int mainTrackId;
        private int createEventId;
        private Object titbitImages;
        private int listenerCount;
        private int serialNum;
        private long scheduledPublishTime;
        private long coverId;
        private int smallLanguageAuditStatus;
        private int categoryId;
        private List<?> channels;
        private int pubStatus;
        private int bdAuditStatus;
        private int secondCategoryId;
        private String coverUrl;
        private String commentThreadId;
        private boolean privacy;
        private int programFeeType;
        private boolean reward;
        private int subscribedCount;
        private Object titbits;
        private int feeScope;
        private String name;
        private long id;
        private String description;
        private long createTime;
        private int shareCount;
        private boolean subscribed;
        private int likedCount;
        private int commentCount;

        public MainSongBean getMainSong() {
            return mainSong;
        }

        public void setMainSong(MainSongBean mainSong) {
            this.mainSong = mainSong;
        }

        public Object getSongs() {
            return songs;
        }

        public void setSongs(Object songs) {
            this.songs = songs;
        }

        public DjBean getDj() {
            return dj;
        }

        public void setDj(DjBean dj) {
            this.dj = dj;
        }

        public String getBlurCoverUrl() {
            return blurCoverUrl;
        }

        public void setBlurCoverUrl(String blurCoverUrl) {
            this.blurCoverUrl = blurCoverUrl;
        }

        public RadioBean getRadio() {
            return radio;
        }

        public void setRadio(RadioBean radio) {
            this.radio = radio;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public Object getAuthDTO() {
            return authDTO;
        }

        public void setAuthDTO(Object authDTO) {
            this.authDTO = authDTO;
        }

        public boolean isBuyed() {
            return buyed;
        }

        public void setBuyed(boolean buyed) {
            this.buyed = buyed;
        }

        public Object getProgramDesc() {
            return programDesc;
        }

        public void setProgramDesc(Object programDesc) {
            this.programDesc = programDesc;
        }

        public Object getH5Links() {
            return h5Links;
        }

        public void setH5Links(Object h5Links) {
            this.h5Links = h5Links;
        }

        public boolean isCanReward() {
            return canReward;
        }

        public void setCanReward(boolean canReward) {
            this.canReward = canReward;
        }

        public int getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(int auditStatus) {
            this.auditStatus = auditStatus;
        }

        public Object getVideoInfo() {
            return videoInfo;
        }

        public void setVideoInfo(Object videoInfo) {
            this.videoInfo = videoInfo;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public Object getLiveInfo() {
            return liveInfo;
        }

        public void setLiveInfo(Object liveInfo) {
            this.liveInfo = liveInfo;
        }

        public Object getAlg() {
            return alg;
        }

        public void setAlg(Object alg) {
            this.alg = alg;
        }

        public Object getDisPlayStatus() {
            return disPlayStatus;
        }

        public void setDisPlayStatus(Object disPlayStatus) {
            this.disPlayStatus = disPlayStatus;
        }

        public int getAuditDisPlayStatus() {
            return auditDisPlayStatus;
        }

        public void setAuditDisPlayStatus(int auditDisPlayStatus) {
            this.auditDisPlayStatus = auditDisPlayStatus;
        }

        public Object getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(Object categoryName) {
            this.categoryName = categoryName;
        }

        public Object getSecondCategoryName() {
            return secondCategoryName;
        }

        public void setSecondCategoryName(Object secondCategoryName) {
            this.secondCategoryName = secondCategoryName;
        }

        public boolean isExistLyric() {
            return existLyric;
        }

        public void setExistLyric(boolean existLyric) {
            this.existLyric = existLyric;
        }

        public Object getDjPlayRecordVo() {
            return djPlayRecordVo;
        }

        public void setDjPlayRecordVo(Object djPlayRecordVo) {
            this.djPlayRecordVo = djPlayRecordVo;
        }

        public boolean isRecommended() {
            return recommended;
        }

        public void setRecommended(boolean recommended) {
            this.recommended = recommended;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getAdIconInfo() {
            return adIconInfo;
        }

        public void setAdIconInfo(Object adIconInfo) {
            this.adIconInfo = adIconInfo;
        }

        public boolean isIsPublish() {
            return isPublish;
        }

        public void setIsPublish(boolean isPublish) {
            this.isPublish = isPublish;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getMainTrackId() {
            return mainTrackId;
        }

        public void setMainTrackId(int mainTrackId) {
            this.mainTrackId = mainTrackId;
        }

        public int getCreateEventId() {
            return createEventId;
        }

        public void setCreateEventId(int createEventId) {
            this.createEventId = createEventId;
        }

        public Object getTitbitImages() {
            return titbitImages;
        }

        public void setTitbitImages(Object titbitImages) {
            this.titbitImages = titbitImages;
        }

        public int getListenerCount() {
            return listenerCount;
        }

        public void setListenerCount(int listenerCount) {
            this.listenerCount = listenerCount;
        }

        public int getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(int serialNum) {
            this.serialNum = serialNum;
        }

        public long getScheduledPublishTime() {
            return scheduledPublishTime;
        }

        public void setScheduledPublishTime(long scheduledPublishTime) {
            this.scheduledPublishTime = scheduledPublishTime;
        }

        public long getCoverId() {
            return coverId;
        }

        public void setCoverId(long coverId) {
            this.coverId = coverId;
        }

        public int getSmallLanguageAuditStatus() {
            return smallLanguageAuditStatus;
        }

        public void setSmallLanguageAuditStatus(int smallLanguageAuditStatus) {
            this.smallLanguageAuditStatus = smallLanguageAuditStatus;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public List<?> getChannels() {
            return channels;
        }

        public void setChannels(List<?> channels) {
            this.channels = channels;
        }

        public int getPubStatus() {
            return pubStatus;
        }

        public void setPubStatus(int pubStatus) {
            this.pubStatus = pubStatus;
        }

        public int getBdAuditStatus() {
            return bdAuditStatus;
        }

        public void setBdAuditStatus(int bdAuditStatus) {
            this.bdAuditStatus = bdAuditStatus;
        }

        public int getSecondCategoryId() {
            return secondCategoryId;
        }

        public void setSecondCategoryId(int secondCategoryId) {
            this.secondCategoryId = secondCategoryId;
        }

        public String getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(String coverUrl) {
            this.coverUrl = coverUrl;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public boolean isPrivacy() {
            return privacy;
        }

        public void setPrivacy(boolean privacy) {
            this.privacy = privacy;
        }

        public int getProgramFeeType() {
            return programFeeType;
        }

        public void setProgramFeeType(int programFeeType) {
            this.programFeeType = programFeeType;
        }

        public boolean isReward() {
            return reward;
        }

        public void setReward(boolean reward) {
            this.reward = reward;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public Object getTitbits() {
            return titbits;
        }

        public void setTitbits(Object titbits) {
            this.titbits = titbits;
        }

        public int getFeeScope() {
            return feeScope;
        }

        public void setFeeScope(int feeScope) {
            this.feeScope = feeScope;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public int getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(int likedCount) {
            this.likedCount = likedCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public static class MainSongBean {
            private String name;
            private int id;
            private int position;
            private List<?> alias;
            private int status;
            private int fee;
            private int copyrightId;
            private String disc;
            private int no;
            private List<ArtistsBean> artists;
            private AlbumBean album;
            private boolean starred;
            private int popularity;
            private int score;
            private int starredNum;
            private int duration;
            private int playedNum;
            private int dayPlays;
            private int hearTime;
            private String ringtone;
            private Object crbt;
            private Object audition;
            private String copyFrom;
            private String commentThreadId;
            private Object rtUrl;
            private int ftype;
            private List<?> rtUrls;
            private int copyright;
            private Object transName;
            private Object sign;
            private int mark;
            private Object noCopyrightRcmd;
            private Object hMusic;
            private Object mMusic;
            private LMusicBean lMusic;
            private BMusicBean bMusic;
            private int rtype;
            private Object rurl;
            private int mvid;
            private Object mp3Url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getDisc() {
                return disc;
            }

            public void setDisc(String disc) {
                this.disc = disc;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public List<ArtistsBean> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBean> artists) {
                this.artists = artists;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public boolean isStarred() {
                return starred;
            }

            public void setStarred(boolean starred) {
                this.starred = starred;
            }

            public int getPopularity() {
                return popularity;
            }

            public void setPopularity(int popularity) {
                this.popularity = popularity;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getStarredNum() {
                return starredNum;
            }

            public void setStarredNum(int starredNum) {
                this.starredNum = starredNum;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlayedNum() {
                return playedNum;
            }

            public void setPlayedNum(int playedNum) {
                this.playedNum = playedNum;
            }

            public int getDayPlays() {
                return dayPlays;
            }

            public void setDayPlays(int dayPlays) {
                this.dayPlays = dayPlays;
            }

            public int getHearTime() {
                return hearTime;
            }

            public void setHearTime(int hearTime) {
                this.hearTime = hearTime;
            }

            public String getRingtone() {
                return ringtone;
            }

            public void setRingtone(String ringtone) {
                this.ringtone = ringtone;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public Object getAudition() {
                return audition;
            }

            public void setAudition(Object audition) {
                this.audition = audition;
            }

            public String getCopyFrom() {
                return copyFrom;
            }

            public void setCopyFrom(String copyFrom) {
                this.copyFrom = copyFrom;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public List<?> getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            public int getCopyright() {
                return copyright;
            }

            public void setCopyright(int copyright) {
                this.copyright = copyright;
            }

            public Object getTransName() {
                return transName;
            }

            public void setTransName(Object transName) {
                this.transName = transName;
            }

            public Object getSign() {
                return sign;
            }

            public void setSign(Object sign) {
                this.sign = sign;
            }

            public int getMark() {
                return mark;
            }

            public void setMark(int mark) {
                this.mark = mark;
            }

            public Object getNoCopyrightRcmd() {
                return noCopyrightRcmd;
            }

            public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
                this.noCopyrightRcmd = noCopyrightRcmd;
            }

            public Object getHMusic() {
                return hMusic;
            }

            public void setHMusic(Object hMusic) {
                this.hMusic = hMusic;
            }

            public Object getMMusic() {
                return mMusic;
            }

            public void setMMusic(Object mMusic) {
                this.mMusic = mMusic;
            }

            public LMusicBean getLMusic() {
                return lMusic;
            }

            public void setLMusic(LMusicBean lMusic) {
                this.lMusic = lMusic;
            }

            public BMusicBean getBMusic() {
                return bMusic;
            }

            public void setBMusic(BMusicBean bMusic) {
                this.bMusic = bMusic;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public int getMvid() {
                return mvid;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public Object getMp3Url() {
                return mp3Url;
            }

            public void setMp3Url(Object mp3Url) {
                this.mp3Url = mp3Url;
            }

            public static class AlbumBean {
                private String name;
                private int id;
                private Object type;
                private int size;
                private long picId;
                private String blurPicUrl;
                private int companyId;
                private long pic;
                private String picUrl;
                private int publishTime;
                private String description;
                private String tags;
                private Object company;
                private String briefDesc;
                private ArtistBean artist;
                private List<?> songs;
                private List<?> alias;
                private int status;
                private int copyrightId;
                private String commentThreadId;
                private List<ArtistsBean> artists;
                private Object subType;
                private Object transName;
                private int mark;
                private String picId_str;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public Object getType() {
                    return type;
                }

                public void setType(Object type) {
                    this.type = type;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public String getBlurPicUrl() {
                    return blurPicUrl;
                }

                public void setBlurPicUrl(String blurPicUrl) {
                    this.blurPicUrl = blurPicUrl;
                }

                public int getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(int companyId) {
                    this.companyId = companyId;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public int getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(int publishTime) {
                    this.publishTime = publishTime;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getTags() {
                    return tags;
                }

                public void setTags(String tags) {
                    this.tags = tags;
                }

                public Object getCompany() {
                    return company;
                }

                public void setCompany(Object company) {
                    this.company = company;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public ArtistBean getArtist() {
                    return artist;
                }

                public void setArtist(ArtistBean artist) {
                    this.artist = artist;
                }

                public List<?> getSongs() {
                    return songs;
                }

                public void setSongs(List<?> songs) {
                    this.songs = songs;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public String getCommentThreadId() {
                    return commentThreadId;
                }

                public void setCommentThreadId(String commentThreadId) {
                    this.commentThreadId = commentThreadId;
                }

                public List<ArtistsBean> getArtists() {
                    return artists;
                }

                public void setArtists(List<ArtistsBean> artists) {
                    this.artists = artists;
                }

                public Object getSubType() {
                    return subType;
                }

                public void setSubType(Object subType) {
                    this.subType = subType;
                }

                public Object getTransName() {
                    return transName;
                }

                public void setTransName(Object transName) {
                    this.transName = transName;
                }

                public int getMark() {
                    return mark;
                }

                public void setMark(int mark) {
                    this.mark = mark;
                }

                public String getPicId_str() {
                    return picId_str;
                }

                public void setPicId_str(String picId_str) {
                    this.picId_str = picId_str;
                }

                public static class ArtistBean {
                    private String name;
                    private int id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private List<?> alias;
                    private String trans;
                    private int musicSize;
                    private int topicPerson;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public int getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(int topicPerson) {
                        this.topicPerson = topicPerson;
                    }
                }

                public static class ArtistsBean {
                    private String name;
                    private int id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private List<?> alias;
                    private String trans;
                    private int musicSize;
                    private int topicPerson;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public int getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(int topicPerson) {
                        this.topicPerson = topicPerson;
                    }
                }
            }

            public static class LMusicBean {
                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private int volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public int getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(int volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class BMusicBean {
                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private int volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public int getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(int volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class ArtistsBean {
                private String name;
                private int id;
                private int picId;
                private int img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private List<?> alias;
                private String trans;
                private int musicSize;
                private int topicPerson;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(int img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public int getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(int topicPerson) {
                    this.topicPerson = topicPerson;
                }
            }
        }

        public static class DjBean {
            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private int authenticationTypes;
            private Object avatarDetail;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private boolean anchor;
            private String avatarImgId_str;
            private String brand;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public int getAuthenticationTypes() {
                return authenticationTypes;
            }

            public void setAuthenticationTypes(int authenticationTypes) {
                this.authenticationTypes = authenticationTypes;
            }

            public Object getAvatarDetail() {
                return avatarDetail;
            }

            public void setAvatarDetail(Object avatarDetail) {
                this.avatarDetail = avatarDetail;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public boolean isAnchor() {
                return anchor;
            }

            public void setAnchor(boolean anchor) {
                this.anchor = anchor;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }
        }

        public static class RadioBean {
            private Object dj;
            private String category;
            private String secondCategory;
            private boolean buyed;
            private int price;
            private int originalPrice;
            private Object discountPrice;
            private int purchaseCount;
            private Object lastProgramName;
            private Object videos;
            private boolean finished;
            private boolean underShelf;
            private Object liveInfo;
            private int playCount;
            private boolean privacy;
            private Object icon;
            private Object manualTagsDTO;
            private Object descPicList;
            private Object shortName;
            private boolean dynamic;
            private int programCount;
            private int categoryId;
            private int taskId;
            private int subCount;
            private long picId;
            private String intervenePicUrl;
            private long intervenePicId;
            private String picUrl;
            private long lastProgramCreateTime;
            private int radioFeeType;
            private long lastProgramId;
            private int feeScope;
            private String name;
            private int id;
            private String desc;
            private long createTime;

            public Object getDj() {
                return dj;
            }

            public void setDj(Object dj) {
                this.dj = dj;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getSecondCategory() {
                return secondCategory;
            }

            public void setSecondCategory(String secondCategory) {
                this.secondCategory = secondCategory;
            }

            public boolean isBuyed() {
                return buyed;
            }

            public void setBuyed(boolean buyed) {
                this.buyed = buyed;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(int originalPrice) {
                this.originalPrice = originalPrice;
            }

            public Object getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(Object discountPrice) {
                this.discountPrice = discountPrice;
            }

            public int getPurchaseCount() {
                return purchaseCount;
            }

            public void setPurchaseCount(int purchaseCount) {
                this.purchaseCount = purchaseCount;
            }

            public Object getLastProgramName() {
                return lastProgramName;
            }

            public void setLastProgramName(Object lastProgramName) {
                this.lastProgramName = lastProgramName;
            }

            public Object getVideos() {
                return videos;
            }

            public void setVideos(Object videos) {
                this.videos = videos;
            }

            public boolean isFinished() {
                return finished;
            }

            public void setFinished(boolean finished) {
                this.finished = finished;
            }

            public boolean isUnderShelf() {
                return underShelf;
            }

            public void setUnderShelf(boolean underShelf) {
                this.underShelf = underShelf;
            }

            public Object getLiveInfo() {
                return liveInfo;
            }

            public void setLiveInfo(Object liveInfo) {
                this.liveInfo = liveInfo;
            }

            public int getPlayCount() {
                return playCount;
            }

            public void setPlayCount(int playCount) {
                this.playCount = playCount;
            }

            public boolean isPrivacy() {
                return privacy;
            }

            public void setPrivacy(boolean privacy) {
                this.privacy = privacy;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public Object getManualTagsDTO() {
                return manualTagsDTO;
            }

            public void setManualTagsDTO(Object manualTagsDTO) {
                this.manualTagsDTO = manualTagsDTO;
            }

            public Object getDescPicList() {
                return descPicList;
            }

            public void setDescPicList(Object descPicList) {
                this.descPicList = descPicList;
            }

            public Object getShortName() {
                return shortName;
            }

            public void setShortName(Object shortName) {
                this.shortName = shortName;
            }

            public boolean isDynamic() {
                return dynamic;
            }

            public void setDynamic(boolean dynamic) {
                this.dynamic = dynamic;
            }

            public int getProgramCount() {
                return programCount;
            }

            public void setProgramCount(int programCount) {
                this.programCount = programCount;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public int getSubCount() {
                return subCount;
            }

            public void setSubCount(int subCount) {
                this.subCount = subCount;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public String getIntervenePicUrl() {
                return intervenePicUrl;
            }

            public void setIntervenePicUrl(String intervenePicUrl) {
                this.intervenePicUrl = intervenePicUrl;
            }

            public long getIntervenePicId() {
                return intervenePicId;
            }

            public void setIntervenePicId(long intervenePicId) {
                this.intervenePicId = intervenePicId;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public long getLastProgramCreateTime() {
                return lastProgramCreateTime;
            }

            public void setLastProgramCreateTime(long lastProgramCreateTime) {
                this.lastProgramCreateTime = lastProgramCreateTime;
            }

            public int getRadioFeeType() {
                return radioFeeType;
            }

            public void setRadioFeeType(int radioFeeType) {
                this.radioFeeType = radioFeeType;
            }

            public long getLastProgramId() {
                return lastProgramId;
            }

            public void setLastProgramId(long lastProgramId) {
                this.lastProgramId = lastProgramId;
            }

            public int getFeeScope() {
                return feeScope;
            }

            public void setFeeScope(int feeScope) {
                this.feeScope = feeScope;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }
    }
}
