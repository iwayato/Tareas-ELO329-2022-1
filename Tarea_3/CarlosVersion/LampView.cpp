#include "LampView.h"


LampView::LampView(int channel)
{
    this->channel = channel;
    State = false;
    color = Qt::black;

    head = new QGraphicsPolygonItem();
    QPolygon polygon;
    polygon << QPoint(-25,0) << QPoint(25,0) << QPoint(50,75) << QPoint(-50,75);
    head->setPolygon(polygon);
    head->setBrush(color);

    body = new QGraphicsPolygonItem();
    QPolygon polygon2;
    polygon2 << QPoint(-2,0) << QPoint(2,0) << QPoint(2,150) << QPoint(25,150) << QPoint(35,160) << QPoint(35,180) << QPoint(-35,180) << QPoint(-35,160) << QPoint(-25,150) << QPoint(-2,150);
    body->setPolygon(polygon2);
    body->setBrush(Qt::yellow);
    addItem(body);
    addItem(head);

}

void LampView::ChangeState()
{
    State = !State;
    if(State)
    {
        head->setBrush(color);
    }
    else
    {

        head->setBrush(Qt::black);
    }

}

void LampView::ChangeIntensity(int value)
{
    color.setHsv(0,0,value);
    if(State)
    {
        head->setBrush(color);
    }
    else
    {
        head->setBrush(Qt::black);
    }
}

void LampView::ChangeR(int value)
{
    color.setRed(value);
    if(State)
    {
        head->setBrush(color);
    }
    else
    {
        head->setBrush(Qt::black);
    }
}

void LampView::ChangeG(int value)
{
    color.setGreen(value);
    if(State)
    {
        head->setBrush(color);
    }
    else
    {
        head->setBrush(Qt::black);
    }
}

void LampView::ChangeB(int value)
{
    color.setBlue(value);
    if(State)
    {
        head->setBrush(color);
    }
    else
    {
        head->setBrush(Qt::black);
    }
}

void LampView::setDefault()
{
    color = Qt::black;
    head->setBrush(color);
}

int LampView::getChannel()
{
    return channel;
}


