import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exercis4.databinding.ObjetItemBinding
import com.example.exercis4.models.Objet

class ObjetAdapter : ListAdapter<Objet, ObjetAdapter.ObjetItemViewHolder>(ObjetItemDiffCallback) {

    // binding nous permet d'accéder à tout le champs de notre layout personne_item.xml
    inner class ObjetItemViewHolder(private val binding: ObjetItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(objet: Objet) {
            binding.tvNombre.text = objet.nombre.toString()
            binding.tvDescription.text = objet.description
            binding.tvRepresentation.text = objet.representation

        }
    }

    object ObjetItemDiffCallback : DiffUtil.ItemCallback<Objet>() {
        override fun areItemsTheSame(oldItem: Objet, newItem: Objet): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Objet, newItem: Objet): Boolean {
            return oldItem.nombre == newItem.nombre &&
                    oldItem.description == newItem.description &&
                    oldItem.representation == newItem.representation

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjetItemViewHolder {
        val binding: ObjetItemBinding = ObjetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ObjetItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObjetItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}