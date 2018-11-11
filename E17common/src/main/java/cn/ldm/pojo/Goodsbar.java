package cn.ldm.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2018-08-03
 */
public class Goodsbar {
    private Integer id;

    private Integer goodsId;

    private Integer number;

    private Integer custId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }
}