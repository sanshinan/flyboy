package com.example.day01.bean;

import java.io.Serializable;
import java.util.List;

public class TwoBean {

    /**
     * message : 请求iii成功
     * code : 200
     * studenlist : [{"name":"张中","skill":"90","theory":"90"},{"name":"李龙","skill":"80","theory":"90"},{"name":"王虎","skill":"100","theory":"70"},{"name":"赵牛","skill":"95","theory":"80"},{"name":"郝分","skill":"85","theory":"86"},{"name":"李彦明","skill":"95","theory":"99"},{"name":"梁洪斌","skill":"75","theory":"65"},{"name":"张全中","skill":"80","theory":"82"},{"name":"肖硕","skill":"100","theory":"100"},{"name":"宋小斌","skill":"85","theory":"90"},{"name":"周国强","skill":"40","theory":"50"},{"name":"许国庆","skill":"65","theory":"80"},{"name":"樊雨欣","skill":"95","theory":"92"},{"name":"魏勋","skill":"98","theory":"94"},{"name":"谢嫔","skill":"100","theory":"91"},{"name":"任志忠","skill":"99","theory":"93"}]
     */

    private String message;
    private String code;
    private List<StudenlistBean> studenlist;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<StudenlistBean> getStudenlist() {
        return studenlist;
    }

    public void setStudenlist(List<StudenlistBean> studenlist) {
        this.studenlist = studenlist;
    }

    public static class StudenlistBean implements Serializable {
        /**
         * name : 张中
         * skill : 90
         * theory : 90
         */

        private String name;
        private String skill;
        private String theory;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }

        public String getTheory() {
            return theory;
        }

        public void setTheory(String theory) {
            this.theory = theory;
        }
    }
}
