#ifndef LAMPCONTROL_H
#define LAMPCONTROL_H

#include "Cloud.h"

class LampControl
{
    private:
        Cloud* c;  //Nube con la que se contactará el control

    public:
        LampControl(Cloud* nube);  //Constructor
        void ButtonPressed(int channel); //Prende o apaga la lampara
        void ChangeIntensity(int channel, int value);
};

#endif // LAMPCONTROL_H
