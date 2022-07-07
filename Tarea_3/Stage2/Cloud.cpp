#include "Cloud.h"

Cloud::Cloud(Lampview* lampara)
{
    lamp = lampara;
}

void Cloud::changeLampState()
{
    lamp->ChangeState();
}

void Cloud::ChangeIntensityLamp(int value)
{
    lamp->ChangeIntensity(value);
}
