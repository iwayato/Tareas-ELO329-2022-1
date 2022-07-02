#ifndef LAMPCONTROL_H
#define LAMPCONTROL_H

#include "Cloud.h"

class LampControl
{
private:
    Cloud* c;

public:
    LampControl(Cloud* nube);
    void ButtonPressed();
};

#endif // LAMPCONTROL_H
