#ifndef CLOUD_H
#define CLOUD_H

#include "Lampview.h"

class Cloud
{
    private:
        Lampview* lamp;  //Lampara que manejará la nube

    public:
        Cloud(Lampview* lampara);  //Constructor
        void changeLampState();    //Cambia el estado de la lampara
        void ChangeIntensityLamp(int value);
};

#endif // CLOUD_H
