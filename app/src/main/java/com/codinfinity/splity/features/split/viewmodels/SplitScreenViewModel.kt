package com.codinfinity.splity.features.split.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codinfinity.splity.core.services.api.SupabaseAPI
import com.codinfinity.splity.domain.repository.SplitRepository
import com.codinfinity.splity.features.split.data.SplitData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplitViewModel @Inject constructor(
    private val api: SupabaseAPI,
    private val repository: SplitRepository
):ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result


    fun OnSplitClicked(onComplete: () -> Unit) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
//                val response = api.callSmartResponder(
//                    mapOf(
//                        "name" to "Amaan",
//                    )
//                )
//                val message = response.body()?.let {
//                    _result.value = it.toString()
//                }
//                Log.d("AddSplit", "OnSplitClicked: $message")

                repository.addSplit(SplitData(
                    amount = 3.0,
                    description = "",
                    date = "",
                    category = "",
                    splitWith = listOf()
                ))

            } catch (e: Exception) {
                _result.value = result.toString() // or handle error
            } finally {
                _isLoading.value = false
                if (_result.value==null) {
                    onComplete()
                } else {
                    // Handle error case
                }
            }
        }
    }
}
//    private val _splitData = MutableLiveData<SplitData>()
//    val splitData: LiveData<SplitData> get() = _splitData
//    var splits:List<SplitData> = emptyList()
//    fun setSplitData(data: SplitData) {
//        _splitData.postValue(data)
//    }
//
//    fun splitBill(){
//        if(_splitData.value==null)
//        {
//            return
//        }
//        else
//        {
//            val currentData = _splitData.value
//            if (currentData != null) {
//                splits as MutableList<SplitData>
//                splits = splits.toMutableList().apply { add(currentData) }
//            }
//        }
//    }
//