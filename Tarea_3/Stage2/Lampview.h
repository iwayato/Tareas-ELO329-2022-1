#ifndef LAMPVIEW_H
#define LAMPVIEW_H

// Librerías a ser utilizadas en el programa
#include <QGraphicsScene>
#include <QGraphicsPolygonItem>
#include <QColor>

class Lampview:public QGraphicsScene
{

    private:
    bool State; //Estado de la Lampara. TRUE = Encendido ; FALSE = Apagado
    QColor color;
    QGraphicsPolygonItem* head;   //Cabeza de la lampara
    QGraphicsPolygonItem* body;   //Cuerpo de la lampara

    public:
        Lampview();               //Constructor
        void ChangeState();       //Hace un toggle del estado de la lampara
        void ChangeIntensity(int value);
        int getChannel();         //Retorna el canal de la lampara

};

#endif // LAMPVIEW_H
