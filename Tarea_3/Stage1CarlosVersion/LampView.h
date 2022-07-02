#ifndef LAMPVIEW_H
#define LAMPVIEW_H

#include <QGraphicsScene>
#include <QGraphicsPolygonItem>
#include <QColor>

class LampView:public QGraphicsScene
{
public:
    LampView(int channel);
    void ChangeState();
    void ChangeIntensity(int value);
    void ChangeR(int value);
    void ChangeG(int value);
    void ChangeB(int value);
    void setDefault();
    int getChannel();
private:
    bool State;
    QGraphicsPolygonItem* head;
    QGraphicsPolygonItem* body;
    QColor color;
    int channel;
};

#endif // LAMPVIEW_H
