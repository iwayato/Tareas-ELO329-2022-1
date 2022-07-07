#include "Cloud.h"

Cloud::Cloud(Lampview* lampara)
{
    lamp = lampara;
}

void Cloud::changeLampState()
{
    lamp->ChangeState();
}
