package com.zrq.azi.bean;

import androidx.annotation.Keep;

import java.util.List;

@Keep
public class Dj {

    private long count;
    private long code;
    private List<ProgramsBean> programs;
    private boolean more;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
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
        private long duration;
        private Object authDTO;
        private boolean buyed;
        private Object programDesc;
        private Object h5Links;
        private boolean canReward;
        private long auditStatus;
        private Object videoInfo;
        private long score;
        private Object liveInfo;
        private Object alg;
        private Object disPlayStatus;
        private long auditDisPlayStatus;
        private Object categoryName;
        private Object secondCategoryName;
        private boolean existLyric;
        private Object djPlayRecordVo;
        private boolean recommended;
        private Object icon;
        private Object adIconInfo;
        private boolean isPublish;
        private long trackCount;
        private long malongrackId;
        private long createEventId;
        private Object titbitImages;
        private long listenerCount;
        private long serialNum;
        private long scheduledPublishTime;
        private long coverId;
        private long smallLanguageAuditStatus;
        private long categoryId;
        private List<?> channels;
        private long pubStatus;
        private long bdAuditStatus;
        private long secondCategoryId;
        private String coverUrl;
        private String commentThreadId;
        private boolean privacy;
        private long programFeeType;
        private boolean reward;
        private long subscribedCount;
        private Object titbits;
        private long feeScope;
        private String name;
        private long id;
        private String description;
        private long createTime;
        private long shareCount;
        private boolean subscribed;
        private long likedCount;
        private long commentCount;
        private long _id;

        public long get_id() {
            return _id;
        }

        public void set_id(long _id) {
            this._id = _id;
        }

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

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
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

        public long getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(long auditStatus) {
            this.auditStatus = auditStatus;
        }

        public Object getVideoInfo() {
            return videoInfo;
        }

        public void setVideoInfo(Object videoInfo) {
            this.videoInfo = videoInfo;
        }

        public long getScore() {
            return score;
        }

        public void setScore(long score) {
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

        public long getAuditDisPlayStatus() {
            return auditDisPlayStatus;
        }

        public void setAuditDisPlayStatus(long auditDisPlayStatus) {
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

        public long getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(long trackCount) {
            this.trackCount = trackCount;
        }

        public long getMalongrackId() {
            return malongrackId;
        }

        public void setMalongrackId(long malongrackId) {
            this.malongrackId = malongrackId;
        }

        public long getCreateEventId() {
            return createEventId;
        }

        public void setCreateEventId(long createEventId) {
            this.createEventId = createEventId;
        }

        public Object getTitbitImages() {
            return titbitImages;
        }

        public void setTitbitImages(Object titbitImages) {
            this.titbitImages = titbitImages;
        }

        public long getListenerCount() {
            return listenerCount;
        }

        public void setListenerCount(long listenerCount) {
            this.listenerCount = listenerCount;
        }

        public long getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(long serialNum) {
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

        public long getSmallLanguageAuditStatus() {
            return smallLanguageAuditStatus;
        }

        public void setSmallLanguageAuditStatus(long smallLanguageAuditStatus) {
            this.smallLanguageAuditStatus = smallLanguageAuditStatus;
        }

        public long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(long categoryId) {
            this.categoryId = categoryId;
        }

        public List<?> getChannels() {
            return channels;
        }

        public void setChannels(List<?> channels) {
            this.channels = channels;
        }

        public long getPubStatus() {
            return pubStatus;
        }

        public void setPubStatus(long pubStatus) {
            this.pubStatus = pubStatus;
        }

        public long getBdAuditStatus() {
            return bdAuditStatus;
        }

        public void setBdAuditStatus(long bdAuditStatus) {
            this.bdAuditStatus = bdAuditStatus;
        }

        public long getSecondCategoryId() {
            return secondCategoryId;
        }

        public void setSecondCategoryId(long secondCategoryId) {
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

        public long getProgramFeeType() {
            return programFeeType;
        }

        public void setProgramFeeType(long programFeeType) {
            this.programFeeType = programFeeType;
        }

        public boolean isReward() {
            return reward;
        }

        public void setReward(boolean reward) {
            this.reward = reward;
        }

        public long getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(long subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public Object getTitbits() {
            return titbits;
        }

        public void setTitbits(Object titbits) {
            this.titbits = titbits;
        }

        public long getFeeScope() {
            return feeScope;
        }

        public void setFeeScope(long feeScope) {
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

        public long getShareCount() {
            return shareCount;
        }

        public void setShareCount(long shareCount) {
            this.shareCount = shareCount;
        }

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public long getLikedCount() {
            return likedCount;
        }

        public void setLikedCount(long likedCount) {
            this.likedCount = likedCount;
        }

        public long getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(long commentCount) {
            this.commentCount = commentCount;
        }

        public static class MainSongBean {
            private String name;
            private long id;
            private long position;
            private List<?> alias;
            private long status;
            private long fee;
            private long copyrightId;
            private String disc;
            private long no;
            private List<ArtistsBean> artists;
            private AlbumBean album;
            private boolean starred;
            private long popularity;
            private long score;
            private long starredNum;
            private long duration;
            private long playedNum;
            private long dayPlays;
            private long hearTime;
            private String ringtone;
            private Object crbt;
            private Object audition;
            private String copyFrom;
            private String commentThreadId;
            private Object rtUrl;
            private long ftype;
            private List<?> rtUrls;
            private long copyright;
            private Object transName;
            private Object sign;
            private long mark;
            private Object noCopyrightRcmd;
            private Object hMusic;
            private Object mMusic;
            private LMusicBean lMusic;
            private BMusicBean bMusic;
            private long rtype;
            private Object rurl;
            private long mvid;
            private Object mp3Url;

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

            public long getPosition() {
                return position;
            }

            public void setPosition(long position) {
                this.position = position;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public long getStatus() {
                return status;
            }

            public void setStatus(long status) {
                this.status = status;
            }

            public long getFee() {
                return fee;
            }

            public void setFee(long fee) {
                this.fee = fee;
            }

            public long getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(long copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getDisc() {
                return disc;
            }

            public void setDisc(String disc) {
                this.disc = disc;
            }

            public long getNo() {
                return no;
            }

            public void setNo(long no) {
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

            public long getPopularity() {
                return popularity;
            }

            public void setPopularity(long popularity) {
                this.popularity = popularity;
            }

            public long getScore() {
                return score;
            }

            public void setScore(long score) {
                this.score = score;
            }

            public long getStarredNum() {
                return starredNum;
            }

            public void setStarredNum(long starredNum) {
                this.starredNum = starredNum;
            }

            public long getDuration() {
                return duration;
            }

            public void setDuration(long duration) {
                this.duration = duration;
            }

            public long getPlayedNum() {
                return playedNum;
            }

            public void setPlayedNum(long playedNum) {
                this.playedNum = playedNum;
            }

            public long getDayPlays() {
                return dayPlays;
            }

            public void setDayPlays(long dayPlays) {
                this.dayPlays = dayPlays;
            }

            public long getHearTime() {
                return hearTime;
            }

            public void setHearTime(long hearTime) {
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

            public long getCopyright() {
                return copyright;
            }

            public void setCopyright(long copyright) {
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

            public long getMark() {
                return mark;
            }

            public void setMark(long mark) {
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

            public long getMvid() {
                return mvid;
            }

            public void setMvid(long mvid) {
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
                private long id;
                private Object type;
                private long size;
                private long picId;
                private String blurPicUrl;
                private long companyId;
                private long pic;
                private String picUrl;
                private long publishTime;
                private String description;
                private String tags;
                private Object company;
                private String briefDesc;
                private ArtistBean artist;
                private List<?> songs;
                private List<?> alias;
                private long status;
                private long copyrightId;
                private String commentThreadId;
                private List<ArtistsBean> artists;
                private Object subType;
                private Object transName;
                private long mark;
                private String picId_str;

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

                public Object getType() {
                    return type;
                }

                public void setType(Object type) {
                    this.type = type;
                }

                public long getSize() {
                    return size;
                }

                public void setSize(long size) {
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

                public long getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(long companyId) {
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

                public long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(long publishTime) {
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

                public long getStatus() {
                    return status;
                }

                public void setStatus(long status) {
                    this.status = status;
                }

                public long getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(long copyrightId) {
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

                public long getMark() {
                    return mark;
                }

                public void setMark(long mark) {
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
                    private long id;
                    private long picId;
                    private long img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private long albumSize;
                    private List<?> alias;
                    private String trans;
                    private long musicSize;
                    private long topicPerson;

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

                    public long getPicId() {
                        return picId;
                    }

                    public void setPicId(long picId) {
                        this.picId = picId;
                    }

                    public long getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(long img1v1Id) {
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

                    public long getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(long albumSize) {
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

                    public long getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(long musicSize) {
                        this.musicSize = musicSize;
                    }

                    public long getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(long topicPerson) {
                        this.topicPerson = topicPerson;
                    }
                }

                public static class ArtistsBean {
                    private String name;
                    private long id;
                    private long picId;
                    private long img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private long albumSize;
                    private List<?> alias;
                    private String trans;
                    private long musicSize;
                    private long topicPerson;

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

                    public long getPicId() {
                        return picId;
                    }

                    public void setPicId(long picId) {
                        this.picId = picId;
                    }

                    public long getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(long img1v1Id) {
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

                    public long getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(long albumSize) {
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

                    public long getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(long musicSize) {
                        this.musicSize = musicSize;
                    }

                    public long getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(long topicPerson) {
                        this.topicPerson = topicPerson;
                    }
                }
            }

            public static class LMusicBean {
                private Object name;
                private long id;
                private long size;
                private String extension;
                private long sr;
                private long dfsId;
                private long bitrate;
                private long playTime;
                private long volumeDelta;

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

                public long getSize() {
                    return size;
                }

                public void setSize(long size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public long getSr() {
                    return sr;
                }

                public void setSr(long sr) {
                    this.sr = sr;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public long getBitrate() {
                    return bitrate;
                }

                public void setBitrate(long bitrate) {
                    this.bitrate = bitrate;
                }

                public long getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(long playTime) {
                    this.playTime = playTime;
                }

                public long getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(long volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class BMusicBean {
                private Object name;
                private long id;
                private long size;
                private String extension;
                private long sr;
                private long dfsId;
                private long bitrate;
                private long playTime;
                private long volumeDelta;

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

                public long getSize() {
                    return size;
                }

                public void setSize(long size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public long getSr() {
                    return sr;
                }

                public void setSr(long sr) {
                    this.sr = sr;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public long getBitrate() {
                    return bitrate;
                }

                public void setBitrate(long bitrate) {
                    this.bitrate = bitrate;
                }

                public long getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(long playTime) {
                    this.playTime = playTime;
                }

                public long getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(long volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class ArtistsBean {
                private String name;
                private long id;
                private long picId;
                private long img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private long albumSize;
                private List<?> alias;
                private String trans;
                private long musicSize;
                private long topicPerson;

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

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public long getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(long img1v1Id) {
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

                public long getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(long albumSize) {
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

                public long getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(long musicSize) {
                    this.musicSize = musicSize;
                }

                public long getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(long topicPerson) {
                    this.topicPerson = topicPerson;
                }
            }
        }

        public static class DjBean {
            private boolean defaultAvatar;
            private long province;
            private long authStatus;
            private boolean followed;
            private String avatarUrl;
            private long accountStatus;
            private long gender;
            private long city;
            private long birthday;
            private long userId;
            private long userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private long authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private long djStatus;
            private long vipType;
            private Object remarkName;
            private long authenticationTypes;
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

            public long getProvince() {
                return province;
            }

            public void setProvince(long province) {
                this.province = province;
            }

            public long getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(long authStatus) {
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

            public long getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(long accountStatus) {
                this.accountStatus = accountStatus;
            }

            public long getGender() {
                return gender;
            }

            public void setGender(long gender) {
                this.gender = gender;
            }

            public long getCity() {
                return city;
            }

            public void setCity(long city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public long getUserType() {
                return userType;
            }

            public void setUserType(long userType) {
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

            public long getAuthority() {
                return authority;
            }

            public void setAuthority(long authority) {
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

            public long getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(long djStatus) {
                this.djStatus = djStatus;
            }

            public long getVipType() {
                return vipType;
            }

            public void setVipType(long vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public long getAuthenticationTypes() {
                return authenticationTypes;
            }

            public void setAuthenticationTypes(long authenticationTypes) {
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
            private long price;
            private long originalPrice;
            private Object discountPrice;
            private long purchaseCount;
            private Object lastProgramName;
            private Object videos;
            private boolean finished;
            private boolean underShelf;
            private Object liveInfo;
            private long playCount;
            private boolean privacy;
            private Object icon;
            private Object manualTagsDTO;
            private Object descPicList;
            private Object shortName;
            private boolean dynamic;
            private long programCount;
            private long categoryId;
            private long taskId;
            private long subCount;
            private long picId;
            private String longervenePicUrl;
            private long longervenePicId;
            private String picUrl;
            private long lastProgramCreateTime;
            private long radioFeeType;
            private long lastProgramId;
            private long feeScope;
            private String name;
            private long id;
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

            public long getPrice() {
                return price;
            }

            public void setPrice(long price) {
                this.price = price;
            }

            public long getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(long originalPrice) {
                this.originalPrice = originalPrice;
            }

            public Object getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(Object discountPrice) {
                this.discountPrice = discountPrice;
            }

            public long getPurchaseCount() {
                return purchaseCount;
            }

            public void setPurchaseCount(long purchaseCount) {
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

            public long getPlayCount() {
                return playCount;
            }

            public void setPlayCount(long playCount) {
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

            public long getProgramCount() {
                return programCount;
            }

            public void setProgramCount(long programCount) {
                this.programCount = programCount;
            }

            public long getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(long categoryId) {
                this.categoryId = categoryId;
            }

            public long getTaskId() {
                return taskId;
            }

            public void setTaskId(long taskId) {
                this.taskId = taskId;
            }

            public long getSubCount() {
                return subCount;
            }

            public void setSubCount(long subCount) {
                this.subCount = subCount;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public String getlongervenePicUrl() {
                return longervenePicUrl;
            }

            public void setlongervenePicUrl(String longervenePicUrl) {
                this.longervenePicUrl = longervenePicUrl;
            }

            public long getlongervenePicId() {
                return longervenePicId;
            }

            public void setlongervenePicId(long longervenePicId) {
                this.longervenePicId = longervenePicId;
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

            public long getRadioFeeType() {
                return radioFeeType;
            }

            public void setRadioFeeType(long radioFeeType) {
                this.radioFeeType = radioFeeType;
            }

            public long getLastProgramId() {
                return lastProgramId;
            }

            public void setLastProgramId(long lastProgramId) {
                this.lastProgramId = lastProgramId;
            }

            public long getFeeScope() {
                return feeScope;
            }

            public void setFeeScope(long feeScope) {
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
