#include "LampControl.h"

LampControl::LampControl(Cloud* nube)
{
    c = nube;
}

void LampControl::ButtonPressed(int channel)
{
    c->changeLampState(channel);
}

void LampControl::ChangeIntensity(int channel, int value)
{
    c->ChangeIntensityLamp(channel, value);
}
