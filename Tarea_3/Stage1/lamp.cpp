#include "lamp.h"

Lamp::Lamp(int channel, QWidget *parent): QWidget{parent}{
    lampChannel = channel;
    state = false;
}

void Lamp::changePowerState(){
    state = state == true ? false : true;
    if (state == false){
        QPainter painter(this);
        painter.drawEllipse(0,0,100,100);
        //Se pinta de negro
        painter.setBrush(Qt::black);
    } else{
        QPainter painter(this);
        painter.drawEllipse(0,0,100,100);
        //Se pinta de blanco
        painter.setBrush(Qt::white);
    }
}

void Lamp::setPowerState(){
    Lamp::changePowerState();
}


