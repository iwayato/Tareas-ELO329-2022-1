#ifndef LAMPCONTROL_H
#define LAMPCONTROL_H

#include "Cloud.h"

class LampControl
{
private:
    Cloud* c;  //Nube con la que se contactará el control

public:
    LampControl(Cloud* nube);  //Constructor
    void ButtonPressed();      //Prende o apaga la lampara
};

#endif // LAMPCONTROL_H
