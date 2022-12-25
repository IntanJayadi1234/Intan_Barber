package org.intan.barbershop.ui.home

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.intan.barbershop.R
import org.intan.barbershop.database.BarberShop
import org.intan.barbershop.databinding.RecyclerviewBarbershopBinding
import org.intan.barbershop.utils.RecyclerViewClickListener
import org.intan.barbershop.utils.convertLongToDateString
import org.intan.barbershop.utils.rupiah

class BarberShopAdapter(
    private val barberShop: List<BarberShop>
) : RecyclerView.Adapter<BarberShopAdapter.BarberShopViewHolder>() {

    var listener: RecyclerViewClickListener? = null

    inner class BarberShopViewHolder(
        val recyclerviewBarbershopBinding: RecyclerviewBarbershopBinding
    ) : RecyclerView.ViewHolder(recyclerviewBarbershopBinding.root)

    override fun getItemCount() = barberShop.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BarberShopViewHolder (
        DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recyclerview_barbershop, parent, false)
    )

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BarberShopViewHolder, position: Int) {
        holder.recyclerviewBarbershopBinding.tvDate.text = convertLongToDateString(barberShop[position].tanggal)
        holder.recyclerviewBarbershopBinding.tvNamaPelanggan.text = barberShop[position].nama
        holder.recyclerviewBarbershopBinding.tvPaket.text = "(${barberShop[position].paket})"
        holder.recyclerviewBarbershopBinding.tvHarga.text = rupiah(barberShop[position].harga)

        when (barberShop[position].paket) {
            ("Haircut & Wash") -> {
                holder.recyclerviewBarbershopBinding.imagePaket.setImageResource(R.drawable.cut_wash)
            }
            ("Haircut") -> {
                holder.recyclerviewBarbershopBinding.imagePaket.setImageResource(R.drawable.haircut)
            }
            ("Full Service") -> {
                holder.recyclerviewBarbershopBinding.imagePaket.setImageResource(R.drawable.full_service)
            }
        }

        holder.recyclerviewBarbershopBinding.listDataCukur.setOnClickListener {
            Log.i("clicked", "oke bisa")
            listener?.onRecyclerViewItemClicked(it, barberShop[position])
        }
    }
}