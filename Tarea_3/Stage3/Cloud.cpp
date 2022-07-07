#include "Cloud.h"

Cloud::Cloud()
{

}

void Cloud::addLampView(Lampview* lamp)
{
    Vistas.push_back(lamp);
}

void Cloud::changeLampState(int channel)
{
    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        if((Vistas.at(i)->getChannel()) == channel)
        {
            Vistas.at(i)->ChangeState();
        }
    }
}

void Cloud::ChangeIntensityLamp(int channel, int value)
{
    int x = Vistas.size();
    for(int i = 0; i < x; i++)
    {
        if((Vistas.at(i)->getChannel()) == channel)
        {
            Vistas.at(i)->ChangeIntensity(value);
        }
    }
}

