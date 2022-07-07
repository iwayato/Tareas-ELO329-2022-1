#ifndef CLOUD_H
#define CLOUD_H

#include "Lampview.h"
#include <vector>
using namespace std;

class Cloud
{
    private:
        vector <Lampview*> Vistas;

    public:
        Cloud();  //Constructor
        void changeLampState(int channel);    //Cambia el estado de la lampara
        void addLampView(Lampview* lamp);
        void powerButtonClicked(int channel);
        void ChangeIntensityLamp(int channel, int value);
};

#endif // CLOUD_H
