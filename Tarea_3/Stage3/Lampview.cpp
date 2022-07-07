#include "Lampview.h"

Lampview::Lampview(int channel)
{
    this->channel = channel;
    State = false;  //Se inicializa la lampara como apagada
    color = Qt::black;

    //Se crea figura para el cuerpo de la lampara
    QPolygon polygon2;
    polygon2 << QPoint(-2,0) << QPoint(2,0) << QPoint(2,150) << QPoint(25,150) << QPoint(35,160) << QPoint(35,180) << QPoint(-35,180) << QPoint(-35,160) << QPoint(-25,150) << QPoint(-2,150);

    //Se le asigna la figura al cuerpo
    body = new QGraphicsPolygonItem();
    body->setPolygon(polygon2);

    //Se pinta de amarillo el cuerpo y se agrega a la vista
    body->setBrush(Qt::yellow);
    addItem(body);


    //Se crea figura para la cabeza de la lampara
    QPolygon polygon;
    polygon << QPoint(-25,0) << QPoint(25,0) << QPoint(50,75) << QPoint(-50,75);

    //Se le asigna la figura a la cabeza
    head = new QGraphicsPolygonItem();
    head->setPolygon(polygon);

    //Se pinta de negro la cabeza y se agrega a la vista
    head->setBrush(Qt::black);
    addItem(head);
}

void Lampview::ChangeState()
{
    State = !State;  //Se hace un toggle al estado de la lampara

    if(State)  //Si la lampara esta encendida, su cabeza se pinta de blanco
    {
        head->setBrush(color);
    }
    else       //Si la lampara esta apagada, su cabeza se pinta de negro
    {
        head->setBrush(Qt::black);
    }
}

void Lampview::ChangeIntensity(int value)
{
    color.setHsv(0,0,value);
    if(State)
    {
        head->setBrush(color);
    }
}

int Lampview::getChannel()
{
    return channel;
}
