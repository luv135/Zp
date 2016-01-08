package com.luo.zp.models;

import java.util.List;

/**
 * Created by Luo on 2016/1/8.
 */
public class MeizhiDetail {
    /**
     * code : 200
     * msg : 查询成功
     * type : RunloveUsers
     * entity : {"uid":2676958084925440,"loginid":"18910091234","runloveid":null,"password":null,"name":"高瑾","phone":"18910091234","headimage":null,"imagekey":"head/image/ea8f1bbc6c0146f8336b9482478f3e43.jpeg","device":null,"token":null,"registertime":"2016-01-08 11:25","sex":2,"birthday":"1992-09-08 00:00","latitude":null,"longitude":null,"logintime":"2016-01-08 11:25","updatetime":"2016-01-08 11:27","status":null,"isclosure":2,"origin":5,"state":"zh_cn","level":0,"faceid":"c0681f109ad7dccaddcb2e4273dc60ea","smallimage":null,"runlovetoken":null,"userinfos":{"uid":2676958084925440,"wechatid":null,"occupation":"画画","declaration":"刚注册的，这个好玩吗","facescore":73,"province":"江苏","city":"南京","homeprovince":"上海","homecity":"上海","marriagestatus":1,"school":"上海音乐学院","updatetime":"2016-01-08 11:27","stature":155,"education":2,"monthlyincome":2,"weight":47,"constellation":null,"nation":"汉族","bloodgroup":"O","housingstatus":1,"carstatus":1,"companyproperty":2,"cookingstate":2,"housework":3,"status":null,"shape":1,"singlestate":null,"workstate":null,"lifestate":null},"age":0,"personalitytitle":[],"matechoice":null,"albums":[],"interests":[]}
     * abnormalType : null
     * page : null
     */

    private int code;
    private String msg;
    private String type;
    /**
     * uid : 2676958084925440
     * loginid : 18910091234
     * runloveid : null
     * password : null
     * name : 高瑾
     * phone : 18910091234
     * headimage : null
     * imagekey : head/image/ea8f1bbc6c0146f8336b9482478f3e43.jpeg
     * device : null
     * token : null
     * registertime : 2016-01-08 11:25
     * sex : 2
     * birthday : 1992-09-08 00:00
     * latitude : null
     * longitude : null
     * logintime : 2016-01-08 11:25
     * updatetime : 2016-01-08 11:27
     * status : null
     * isclosure : 2
     * origin : 5
     * state : zh_cn
     * level : 0
     * faceid : c0681f109ad7dccaddcb2e4273dc60ea
     * smallimage : null
     * runlovetoken : null
     * userinfos : {"uid":2676958084925440,"wechatid":null,"occupation":"画画","declaration":"刚注册的，这个好玩吗","facescore":73,"province":"江苏","city":"南京","homeprovince":"上海","homecity":"上海","marriagestatus":1,"school":"上海音乐学院","updatetime":"2016-01-08 11:27","stature":155,"education":2,"monthlyincome":2,"weight":47,"constellation":null,"nation":"汉族","bloodgroup":"O","housingstatus":1,"carstatus":1,"companyproperty":2,"cookingstate":2,"housework":3,"status":null,"shape":1,"singlestate":null,"workstate":null,"lifestate":null}
     * age : 0
     * personalitytitle : []
     * matechoice : null
     * albums : []
     * interests : []
     */

    private EntityEntity entity;
    private Object abnormalType;
    private Object page;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEntity(EntityEntity entity) {
        this.entity = entity;
    }

    public void setAbnormalType(Object abnormalType) {
        this.abnormalType = abnormalType;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getType() {
        return type;
    }

    public EntityEntity getEntity() {
        return entity;
    }

    public Object getAbnormalType() {
        return abnormalType;
    }

    public Object getPage() {
        return page;
    }

    public static class EntityEntity {
        private long uid;
        private String loginid;
        private Object runloveid;
        private Object password;
        private String name;
        private String phone;
        private Object headimage;
        private String imagekey;
        private Object device;
        private Object token;
        private String registertime;
        private int sex;
        private String birthday;
        private Object latitude;
        private Object longitude;
        private String logintime;
        private String updatetime;
        private Object status;
        private int isclosure;
        private int origin;
        private String state;
        private int level;
        private String faceid;
        private Object smallimage;
        private Object runlovetoken;
        /**
         * uid : 2676958084925440
         * wechatid : null
         * occupation : 画画
         * declaration : 刚注册的，这个好玩吗
         * facescore : 73
         * province : 江苏
         * city : 南京
         * homeprovince : 上海
         * homecity : 上海
         * marriagestatus : 1
         * school : 上海音乐学院
         * updatetime : 2016-01-08 11:27
         * stature : 155
         * education : 2
         * monthlyincome : 2
         * weight : 47
         * constellation : null
         * nation : 汉族
         * bloodgroup : O
         * housingstatus : 1
         * carstatus : 1
         * companyproperty : 2
         * cookingstate : 2
         * housework : 3
         * status : null
         * shape : 1
         * singlestate : null
         * workstate : null
         * lifestate : null
         */

        private UserinfosEntity userinfos;
        private int age;
        private Object matechoice;
        private List<?> personalitytitle;
        private List<?> albums;
        private List<?> interests;

        public void setUid(long uid) {
            this.uid = uid;
        }

        public void setLoginid(String loginid) {
            this.loginid = loginid;
        }

        public void setRunloveid(Object runloveid) {
            this.runloveid = runloveid;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setHeadimage(Object headimage) {
            this.headimage = headimage;
        }

        public void setImagekey(String imagekey) {
            this.imagekey = imagekey;
        }

        public void setDevice(Object device) {
            this.device = device;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public void setRegistertime(String registertime) {
            this.registertime = registertime;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public void setLogintime(String logintime) {
            this.logintime = logintime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public void setIsclosure(int isclosure) {
            this.isclosure = isclosure;
        }

        public void setOrigin(int origin) {
            this.origin = origin;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setFaceid(String faceid) {
            this.faceid = faceid;
        }

        public void setSmallimage(Object smallimage) {
            this.smallimage = smallimage;
        }

        public void setRunlovetoken(Object runlovetoken) {
            this.runlovetoken = runlovetoken;
        }

        public void setUserinfos(UserinfosEntity userinfos) {
            this.userinfos = userinfos;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setMatechoice(Object matechoice) {
            this.matechoice = matechoice;
        }

        public void setPersonalitytitle(List<?> personalitytitle) {
            this.personalitytitle = personalitytitle;
        }

        public void setAlbums(List<?> albums) {
            this.albums = albums;
        }

        public void setInterests(List<?> interests) {
            this.interests = interests;
        }

        public long getUid() {
            return uid;
        }

        public String getLoginid() {
            return loginid;
        }

        public Object getRunloveid() {
            return runloveid;
        }

        public Object getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public Object getHeadimage() {
            return headimage;
        }

        public String getImagekey() {
            return imagekey;
        }

        public Object getDevice() {
            return device;
        }

        public Object getToken() {
            return token;
        }

        public String getRegistertime() {
            return registertime;
        }

        public int getSex() {
            return sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public Object getLatitude() {
            return latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public String getLogintime() {
            return logintime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public Object getStatus() {
            return status;
        }

        public int getIsclosure() {
            return isclosure;
        }

        public int getOrigin() {
            return origin;
        }

        public String getState() {
            return state;
        }

        public int getLevel() {
            return level;
        }

        public String getFaceid() {
            return faceid;
        }

        public Object getSmallimage() {
            return smallimage;
        }

        public Object getRunlovetoken() {
            return runlovetoken;
        }

        public UserinfosEntity getUserinfos() {
            return userinfos;
        }

        public int getAge() {
            return age;
        }

        public Object getMatechoice() {
            return matechoice;
        }

        public List<?> getPersonalitytitle() {
            return personalitytitle;
        }

        public List<?> getAlbums() {
            return albums;
        }

        public List<?> getInterests() {
            return interests;
        }

        public static class UserinfosEntity {
            private long uid;
            private Object wechatid;
            private String occupation;
            private String declaration;
            private int facescore;
            private String province;
            private String city;
            private String homeprovince;
            private String homecity;
            private int marriagestatus;
            private String school;
            private String updatetime;
            private int stature;
            private int education;
            private int monthlyincome;
            private int weight;
            private Object constellation;
            private String nation;
            private String bloodgroup;
            private int housingstatus;
            private int carstatus;
            private int companyproperty;
            private int cookingstate;
            private int housework;
            private Object status;
            private int shape;
            private Object singlestate;
            private Object workstate;
            private Object lifestate;

            public void setUid(long uid) {
                this.uid = uid;
            }

            public void setWechatid(Object wechatid) {
                this.wechatid = wechatid;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public void setDeclaration(String declaration) {
                this.declaration = declaration;
            }

            public void setFacescore(int facescore) {
                this.facescore = facescore;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public void setHomeprovince(String homeprovince) {
                this.homeprovince = homeprovince;
            }

            public void setHomecity(String homecity) {
                this.homecity = homecity;
            }

            public void setMarriagestatus(int marriagestatus) {
                this.marriagestatus = marriagestatus;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public void setStature(int stature) {
                this.stature = stature;
            }

            public void setEducation(int education) {
                this.education = education;
            }

            public void setMonthlyincome(int monthlyincome) {
                this.monthlyincome = monthlyincome;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public void setConstellation(Object constellation) {
                this.constellation = constellation;
            }

            public void setNation(String nation) {
                this.nation = nation;
            }

            public void setBloodgroup(String bloodgroup) {
                this.bloodgroup = bloodgroup;
            }

            public void setHousingstatus(int housingstatus) {
                this.housingstatus = housingstatus;
            }

            public void setCarstatus(int carstatus) {
                this.carstatus = carstatus;
            }

            public void setCompanyproperty(int companyproperty) {
                this.companyproperty = companyproperty;
            }

            public void setCookingstate(int cookingstate) {
                this.cookingstate = cookingstate;
            }

            public void setHousework(int housework) {
                this.housework = housework;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public void setShape(int shape) {
                this.shape = shape;
            }

            public void setSinglestate(Object singlestate) {
                this.singlestate = singlestate;
            }

            public void setWorkstate(Object workstate) {
                this.workstate = workstate;
            }

            public void setLifestate(Object lifestate) {
                this.lifestate = lifestate;
            }

            public long getUid() {
                return uid;
            }

            public Object getWechatid() {
                return wechatid;
            }

            public String getOccupation() {
                return occupation;
            }

            public String getDeclaration() {
                return declaration;
            }

            public int getFacescore() {
                return facescore;
            }

            public String getProvince() {
                return province;
            }

            public String getCity() {
                return city;
            }

            public String getHomeprovince() {
                return homeprovince;
            }

            public String getHomecity() {
                return homecity;
            }

            public int getMarriagestatus() {
                return marriagestatus;
            }

            public String getSchool() {
                return school;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public int getStature() {
                return stature;
            }

            public int getEducation() {
                return education;
            }

            public int getMonthlyincome() {
                return monthlyincome;
            }

            public int getWeight() {
                return weight;
            }

            public Object getConstellation() {
                return constellation;
            }

            public String getNation() {
                return nation;
            }

            public String getBloodgroup() {
                return bloodgroup;
            }

            public int getHousingstatus() {
                return housingstatus;
            }

            public int getCarstatus() {
                return carstatus;
            }

            public int getCompanyproperty() {
                return companyproperty;
            }

            public int getCookingstate() {
                return cookingstate;
            }

            public int getHousework() {
                return housework;
            }

            public Object getStatus() {
                return status;
            }

            public int getShape() {
                return shape;
            }

            public Object getSinglestate() {
                return singlestate;
            }

            public Object getWorkstate() {
                return workstate;
            }

            public Object getLifestate() {
                return lifestate;
            }
        }
    }
}
