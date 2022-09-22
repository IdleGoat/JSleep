package rafieAmandioJSleepJS;

public class Voucher
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(String name, int code, Type type, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean isUsed(){
        return used;
    }

    public boolean canApply(Price price){
        if((price.price > this.minimum) && (!this.used)){
            return true;
        }
            return false;
    }

    public double apply(Price price){
        this.used = true;
        if(this.type == Type.DISCOUNT){
            if(this.cut > 100.0) {
                this.cut = 100.0;
            }
                return price.price - (price.price*(this.cut/100.0));
        }
        else{
            if(this.cut > price.price){
                this.cut = price.price;
            }
                return price.price - this.cut;
        }
    }


}
