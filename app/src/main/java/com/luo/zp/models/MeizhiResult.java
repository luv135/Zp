package com.luo.zp.models;

import java.util.List;

/**
 * Created by Luo on 2016/1/8.
 */
public class MeizhiResult {
    /**
     * code : 200
     * msg : 挑选成功
     * type : List<RunloveUsers>
     * entity : [{"uid":2677123794176000,"loginid":"18910091133","runloveid":null,"password":null,"name":"圆圆","phone":"18910091133","headimage":"http://7xpkw6.com2.z0.glb.qiniucdn.com/head/image/b2ebc9b972e6ea2c5cbf05d6c3b709fb.jpeg?e=1452694872&token=nT0-EDHb9VOejT6132M4gDT4_fnRO08u3K9PSU6Z:A8ACjxN1g8BduC1o9CnIQxiV13E=","imagekey":"head/image/b2ebc9b972e6ea2c5cbf05d6c3b709fb.jpeg","device":null,"token":null,"registertime":"2016-01-08 14:14","sex":2,"birthday":"1992-09-10 00:00","latitude":null,"longitude":null,"logintime":"2016-01-08 14:14","updatetime":"2016-01-08 14:17","status":null,"isclosure":2,"origin":5,"state":"zh_cn","level":0,"faceid":"35158cf1f0abb3d1f2e47ee3697ad608","smallimage":"http://7xpkw6.com2.z0.glb.qiniucdn.com/head/image/b2ebc9b972e6ea2c5cbf05d6c3b709fb.jpeg?imageMogr2/thumbnail/!50p&e=1452694872&token=nT0-EDHb9VOejT6132M4gDT4_fnRO08u3K9PSU6Z:gMYhI0XAqvxseehiCJ19B3T6Vck=","runlovetoken":null,"userinfos":{"uid":2677123794176000,"wechatid":null,"occupation":"客服","declaration":"么么哒 我爱你们","facescore":60,"province":"贵州","city":"贵阳","homeprovince":"贵州","homecity":"贵阳","marriagestatus":1,"school":"毕节学院","updatetime":"2016-01-08 14:17","stature":166,"education":2,"monthlyincome":2,"weight":47,"constellation":null,"nation":"汉族","bloodgroup":"O","housingstatus":1,"carstatus":1,"companyproperty":2,"cookingstate":2,"housework":3,"status":null,"shape":1,"singlestate":null,"workstate":null,"lifestate":null},"age":23,"personalitytitle":null,"matechoice":null,"albums":null,"interests":null},{"uid":2677120985384960,"loginid":"18910097365","runloveid":null,"password":null,"name":"小沐","phone":"18910097365","headimage":"http://7xpkw6.com2.z0.glb.qiniucdn.com/head/image/6ba4e1abe1b1f0057bb4800837deceb8.jpeg?e=1452694872&token=nT0-EDHb9VOejT6132M4gDT4_fnRO08u3K9PSU6Z:EqOy3Nan0nANlIOohBLH85izJ4M=","imagekey":"head/image/6ba4e1abe1b1f0057bb4800837deceb8.jpeg","device":null,"token":null,"registertime":"2016-01-08 14:11","sex":2,"birthday":"1993-09-08 00:00","latitude":null,"longitude":null,"logintime":"2016-01-08 14:11","updatetime":"2016-01-08 14:13","status":null,"isclosure":2,"origin":5,"state":"zh_cn","level":0,"faceid":"5edc94f2ce8b2d1866751d25f49bb0cf","smallimage":"http://7xpkw6.com2.z0.glb.qiniucdn.com/head/image/6ba4e1abe1b1f0057bb4800837deceb8.jpeg?imageMogr2/thumbnail/!50p&e=1452694872&token=nT0-EDHb9VOejT6132M4gDT4_fnRO08u3K9PSU6Z:Clhw1FFCbOoA_VUMZSQmLTvcfvQ=","runlovetoken":null,"userinfos":{"uid":2677120985384960,"wechatid":null,"occupation":"销售","declaration":"有对我有兴趣的么","facescore":67,"province":"江西","city":"赣州","homeprovince":"江西","homecity":"赣州","marriagestatus":1,"school":"天津科技大学","updatetime":"2016-01-08 14:13","stature":166,"education":2,"monthlyincome":2,"weight":47,"constellation":null,"nation":"汉族","bloodgroup":"O","housingstatus":1,"carstatus":1,"companyproperty":2,"cookingstate":2,"housework":3,"status":null,"shape":1,"singlestate":null,"workstate":null,"lifestate":null},"age":22,"personalitytitle":null,"matechoice":null,"albums":null,"interests":null}]
     */

    private int code;
    private String msg;
    private String type;
    /**
     * uid : 2677123794176000
     * loginid : 18910091133
     * runloveid : null
     * password : null
     * name : 圆圆
     * phone : 18910091133
     * headimage : http://7xpkw6.com2.z0.glb.qiniucdn.com/head/image/b2ebc9b972e6ea2c5cbf05d6c3b709fb.jpeg?e=1452694872&token=nT0-EDHb9VOejT6132M4gDT4_fnRO08u3K9PSU6Z:A8ACjxN1g8BduC1o9CnIQxiV13E=
     * imagekey : head/image/b2ebc9b972e6ea2c5cbf05d6c3b709fb.jpeg
     * device : null
     * token : null
     * registertime : 2016-01-08 14:14
     * sex : 2
     * birthday : 1992-09-10 00:00
     * latitude : null
     * longitude : null
     * logintime : 2016-01-08 14:14
     * updatetime : 2016-01-08 14:17
     * status : null
     * isclosure : 2
     * origin : 5
     * state : zh_cn
     * level : 0
     * faceid : 35158cf1f0abb3d1f2e47ee3697ad608
     * smallimage : http://7xpkw6.com2.z0.glb.qiniucdn.com/head/image/b2ebc9b972e6ea2c5cbf05d6c3b709fb.jpeg?imageMogr2/thumbnail/!50p&e=1452694872&token=nT0-EDHb9VOejT6132M4gDT4_fnRO08u3K9PSU6Z:gMYhI0XAqvxseehiCJ19B3T6Vck=
     * runlovetoken : null
     * userinfos : {"uid":2677123794176000,"wechatid":null,"occupation":"客服","declaration":"么么哒 我爱你们","facescore":60,"province":"贵州","city":"贵阳","homeprovince":"贵州","homecity":"贵阳","marriagestatus":1,"school":"毕节学院","updatetime":"2016-01-08 14:17","stature":166,"education":2,"monthlyincome":2,"weight":47,"constellation":null,"nation":"汉族","bloodgroup":"O","housingstatus":1,"carstatus":1,"companyproperty":2,"cookingstate":2,"housework":3,"status":null,"shape":1,"singlestate":null,"workstate":null,"lifestate":null}
     * age : 23
     * personalitytitle : null
     * matechoice : null
     * albums : null
     * interests : null
     */

    private List<Meizhi> entity;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEntity(List<Meizhi> entity) {
        this.entity = entity;
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

    public List<Meizhi> getEntity() {
        return entity;
    }


    @Override
    public String toString() {
        return "MeizhiResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", type='" + type + '\'' +
                ", entity=" + entity +
                '}';
    }
}
