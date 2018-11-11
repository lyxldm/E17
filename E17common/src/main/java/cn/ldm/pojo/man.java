package cn.ldm.pojo;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "m22",type = "m2")
public class man {
    private  Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private String pag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPag() {
        return pag;
    }

    public void setPag(String pag) {
        this.pag = pag;
    }
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pag='" + pag + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
