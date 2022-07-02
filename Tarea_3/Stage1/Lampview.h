#ifndef LAMPVIEW_H
#define LAMPVIEW_H

// Librerías a ser utilizadas en el programa
#include <QGraphicsScene>
#include <QGraphicsPolygonItem>
#include <QColor>

class Lampview:public QGraphicsScene
{

    private:
    bool State;
    QGraphicsPolygonItem* head;
    QGraphicsPolygonItem* body;

    public:
        Lampview();
        void ChangeState();
        int getChannel();

};

#endif // LAMPVIEW_H
