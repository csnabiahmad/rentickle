package com.ropstam.demoapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ropstam.demoapp.R
import com.ropstam.demoapp.model.CategoriesModel
import com.ropstam.demoapp.model.ItemModel
import com.ropstam.demoapp.ui.adapter.CategoryViewAdapter

class HomeViewModel : ViewModel() {

    var listOfCategory : MutableLiveData<MutableList<CategoriesModel>> = MutableLiveData()
    var listOfItems : MutableLiveData<MutableList<ItemModel>> = MutableLiveData()


    fun setCategories(){
        val list = ArrayList<CategoriesModel>()
        list.add(CategoriesModel(R.drawable.ic_bedroom,"Bed Room"))
        list.add(CategoriesModel(R.drawable.ic_livingroom,"Living Room"))
        list.add(CategoriesModel(R.drawable.ic_cameraroom,"DSLR Camera"))
        list.add(CategoriesModel(R.drawable.ic_appliance,"Appliances"))
        list.add(CategoriesModel(R.drawable.ic_storage,"Storage"))
        list.add(CategoriesModel(R.drawable.ic_packages,"Packages"))
        listOfCategory.value = list
    }


    fun setItems(){
        val list = ArrayList<ItemModel>()
        list.add(ItemModel("https://i.ebayimg.com/images/g/0~oAAOSwRyRa~nht/s-l500.jpg","NAVY BLUE HERRINGBONE","£695.00"))
        list.add(ItemModel("https://i.ebayimg.com/images/g/fgAAAOSwittdmnZC/s-l500.jpg","Chesterfield New Sofa Settee","£724.50"))
        list.add(ItemModel("https://i.ebayimg.com/images/g/EX8AAOSwPNxiZ~xd/s-l500.jpg","Harris Tweed Chesterfield patchwork","£1,695.00"))
        list.add(ItemModel("https://i.ebayimg.com/images/g/DasAAOSw5fxioJeI/s-l500.jpg","Classic Solid Wooden Dining Table","£109.99"))
        list.add(ItemModel("https://i.ebayimg.com/images/g/V9wAAOSw41lfdk2K/s-l500.png","Wooden modern marble effect dining table","£249.99"))
        list.add(ItemModel("https://i.ebayimg.com/images/g/QToAAOSwf75hu9jj/s-l500.jpg","White Wooden Dining Table","£315.00"))
        listOfItems.value = list
    }



   }
