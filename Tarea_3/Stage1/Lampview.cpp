#include "Lampview.h"

Lampview::Lampview()
{
    State = false;

    head = new QGraphicsPolygonItem();
    QPolygon polygon;
    polygon << QPoint(-25,0) << QPoint(25,0) << QPoint(50,75) << QPoint(-50,75);
    head->setPolygon(polygon);
    head->setBrush(Qt::black);


    body = new QGraphicsPolygonItem();
    QPolygon polygon2;
    polygon2 << QPoint(-2,0) << QPoint(2,0) << QPoint(2,150) << QPoint(25,150) << QPoint(35,160) << QPoint(35,180) << QPoint(-35,180) << QPoint(-35,160) << QPoint(-25,150) << QPoint(-2,150);
    body->setPolygon(polygon2);
    body->setBrush(Qt::yellow);
    addItem(body);
    addItem(head);

}

void Lampview::ChangeState()
{
    State = !State;

    if(State)
    {
        head->setBrush(Qt::white);
    }
    else
    {

        head->setBrush(Qt::black);
    }

}
