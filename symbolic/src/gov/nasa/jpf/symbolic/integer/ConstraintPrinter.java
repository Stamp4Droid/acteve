package gov.nasa.jpf.symbolic.integer;

public class ConstraintPrinter
{
    static{
	String klassName = System.getProperty("pc.printer", "gov.nasa.jpf.symbolic.integer.ConstraintPrinterBV");
	try{
	    v = (ConstraintPrinter) Class.forName(klassName).newInstance();
	}
	catch(ClassNotFoundException e){
	    throw new Error(e);
	}
	catch(InstantiationException e){
	    throw new Error(e);
	}
	catch(IllegalAccessException e){
	    throw new Error(e);
	}
    }
    
    public static final ConstraintPrinter v;

    public String intConstant(int v){ return String.valueOf(v); }
    
    public String longConstant(long l){ return String.valueOf(v); }
    
    public String floatConstant(float v){ return String.valueOf(v); }
    
    public String doubleConstant(double v){ return String.valueOf(v); }
    
    public String eq(){ return "="; }

    public String lt(){ return "<"; }
    
    public String le(){ return "<="; }
    
    public String gt(){ return ">"; }
    
    public String ge(){ return ">="; }
    
    public String iadd(){ return "+"; }
    
    public String isub(){ return "-"; }
    
    public String imul(){ return "*"; }
    
    public String idiv(){ return "div"; }
    
    public String irem(){ return "rem"; }

    public String ineg(){ return "~"; }

    public String ior(){ return "ior"; }
    
    public String iand(){ return "iand"; }
    
    public String ixor(){ return "ixor"; }
    
    public String ishr(){ return "ishr"; }

    public String ishl(){ return "ishl"; }
    
    public String iushr(){ return "iushr"; }
    
    public String i2s(){ return "i2s"; }
    
    public String i2b(){ return "i2b"; }
    
    public String i2c(){ return "i2c"; }
    
    public String i2l(){ return "i2l"; }
    
    public String i2d(){ return "i2d"; }
    
    public String i2f(){ return "i2f"; }
    
    public String ladd(){ return "+"; }
    
    public String lsub(){ return "-"; }

    public String lmul(){ return "*"; }
    
    public String ldiv(){ return "/"; }
    
    public String lrem(){ return "rem"; }

    public String lneg(){ return "~"; }

    public String lor(){ return "lor"; }
    
    public String land(){ return "land"; }
    
    public String lxor(){ return "lxor"; }
    
    public String lshr(){ return "lshr"; }

    public String lshl(){ return "lshl"; }
    
    public String lushr(){ return "lushr"; }
    
    public String l2i(){ return "l2i"; }
    
    public String l2f(){ return "l2f"; }
    
    public String l2d(){ return "l2d"; }

    public String fadd(){ return "fadd"; }
    
    public String fsub(){ return "fsub"; }

    public String fmul(){ return "fmul"; }
    
    public String fdiv(){ return "fdiv"; }
    
    public String frem(){ return "frem"; }

    public String fneg(){ return "fneg"; }
    
    public String f2i(){ return "f2i"; }
    
    public String f2l(){ return "f2l"; }
    
    public String f2d(){ return "f2d"; }
    
    public String dadd(){ return "dadd"; }
    
    public String dsub(){ return "dsub"; }

    public String dmul(){ return "dmul"; }
    
    public String ddiv(){ return "ddiv"; }
    
    public String drem(){ return "drem"; }

    public String dneg(){ return "dneg"; }
    
    public String d2i(){ return "d2i"; }

    public String d2l(){ return "d2l"; }
    
    public String d2f(){ return "d2f"; }
    
}