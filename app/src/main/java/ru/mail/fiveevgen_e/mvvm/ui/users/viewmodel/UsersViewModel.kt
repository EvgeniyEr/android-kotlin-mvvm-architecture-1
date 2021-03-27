package ru.mail.fiveevgen_e.mvvm.ui.users.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.mail.fiveevgen_e.mvvm.data.api.RemoteDataSource
import ru.mail.fiveevgen_e.mvvm.data.model.User
import ru.mail.fiveevgen_e.mvvm.data.repository.MainRepository
import ru.mail.fiveevgen_e.mvvm.utils.Resource
import java.util.concurrent.TimeUnit

class UsersViewModel : ViewModel() {

    private val mUsers = MutableLiveData<Resource<List<User>>>()
    private val mCompositeDisposable = CompositeDisposable()
    private val mMainRepository = MainRepository(RemoteDataSource())

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        mUsers.postValue(Resource.loading(null)) // В LiveData помещаем объект с оберткой (Resource)
        mCompositeDisposable.add(
            mMainRepository.getUsers()
                .subscribeOn(Schedulers.io()) // Получение Users в другом потоке
                .delay(2, TimeUnit.SECONDS) // TODO (имитация медленного интернета)
                .observeOn(AndroidSchedulers.mainThread()) // Результат обрабатываем опять в главном потоке
                .subscribe({ userList ->
                    mUsers.postValue(Resource.success(userList)) // Помещаем результат в LiveData
                }, { throwable ->
                    mUsers.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    // Этот метод будет вызван, когда эта ViewModel больше не будет использоваться, и будет уничтожена.
    // Это полезно, когда ViewModel наблюдает за некоторыми данными, и вам нужно очистить эту подписку,
    // чтобы предотвратить утечку этой ViewModel.
    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
        // Log.d("MVVM", "Сработал onCleared")
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return mUsers
    }
}