package org.intan.barbershop.utils

import android.view.View
import org.intan.barbershop.database.BarberShop

interface RecyclerViewClickListener {

 fun onRecyclerViewItemClicked(view: View, barberShop: BarberShop)

}