package com.example.quadraticequationsolver;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolver.databinding.ActivityMainBinding;

public class QuadraticEquation extends BaseObservable {

    String a,b,c;

    ActivityMainBinding activityMainBinding;
    public QuadraticEquation() {
        a=null;
        b=null;
        c=null;
    }

    public QuadraticEquation(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding = activityMainBinding;
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
        notifyPropertyChanged(BR.a);
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
        notifyPropertyChanged(BR.b);
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
        notifyPropertyChanged(BR.c);
    }

    public void solveEquation(View v){

        if(a==null||getA().isEmpty()){
            activityMainBinding.editText.setError("Enter a");
        } else if (b==null||getB().isEmpty()) {
            activityMainBinding.editText2.setError("Enter b");
        } else if (c==null||getC().isEmpty()) {
            activityMainBinding.editText3.setError("Enter c");
        }else{
            int value_a=Integer.parseInt(getA());
            int value_b=Integer.parseInt(getB());
            int value_c=Integer.parseInt(getC());

            int discriminant=(value_b*value_b)-4*(value_a*value_c);
            double x1,x2;
            if(discriminant>0){
                x1=(-value_b+Math.sqrt(discriminant))/(2*value_a);
                x2=(-value_b-Math.sqrt(discriminant))/(2*value_a);
                activityMainBinding.result.setText("x1= "+x1+",x2= "+x2);

            } else if (discriminant<0) {
                activityMainBinding.result.setText("no real roots");
            }else{
                x1=-value_b/(2*value_a);
                activityMainBinding.result.setText("x= "+x1);
            }
            activityMainBinding.result.setVisibility(View.VISIBLE);
        }


    }
}
