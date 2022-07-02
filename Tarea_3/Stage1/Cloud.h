#ifndef CLOUD_H
#define CLOUD_H

#include "Lampview.h"

class Cloud
{
private:
    Lampview* lamp;

public:
    Cloud(Lampview* lampara);
    void changeLampState();
};

#endif // CLOUD_H
