#include "LampControl.h"



LampControl::LampControl(Cloud* nube)
{
    c = nube;
}

void LampControl::ButtonPressed()
{
    c->changeLampState();
}
