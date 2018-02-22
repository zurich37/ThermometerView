# ThermometerView 
[![Build Status](http://img.shields.io/badge/release-1.0.1-33af70b.svg)](https://travis-ci.org/zurich37/ThermometerView)  <img src="http://img.shields.io/travis/zurich37/ThermometerView.svg"/>  
This is a custom thermometer view, you can set the progress, the maximum temperature.

## Screenshots  
<img src="https://github.com/zurich37/ThermometerView/blob/master/screenshots/001.jpeg"/>  
##Usage  

#####1.Add as a dependency to your build.gradle:

```
dependencies {  
    compile 'com.zurich.thermometer:ThermometerView:1.0.1'  
}
```

#####2.Add the ``com.zurich.thermometer.ThermometerView`` to your layout XML file.

```
<com.zurich.thermometer.ThermometerView
        android:id="@+id/thermometer_view"
        android:layout_width="150dp"
        android:layout_height="20dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:maxLength="50dp"
        app:radius="10dp"
        app:showNumber="true"
        app:textBold="true"
        app:textSize="14sp"
        tools:layout_width="150dp" />  
```
          

