package com.photy.ui.base.mvp

import com.nhaarman.mockito_kotlin.mock
import org.hamcrest.core.IsEqual
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BasePresenterTest {

  lateinit var fakePresenter: BasePresenter<BaseView>
  lateinit var fakeView: BaseView

  @Before
  fun setUp() {
    fakePresenter = TestPresenter()
    fakeView = mock()
  }

  @Test
  fun viewShouldBeNullByDefaults() {
    assertNull(fakePresenter.getView())
  }

  @Test
  fun attachedViewShouldNotBeNull() {
    fakePresenter.attachView(fakeView)
    assertNotNull(fakePresenter.getView())
  }

  @Test
  fun detachedViewShouldBeNull() {
    fakePresenter.attachView(fakeView)
    fakePresenter.detachView()
    assertNull(fakePresenter.getView())
  }

  @Test
  fun getViewShouldBeReturnAttachedView() {
    fakePresenter.attachView(fakeView)
    assertThat(fakePresenter.getView(), IsEqual(fakeView))
  }

  class TestPresenter : BasePresenter<BaseView>() {
    override fun init() {}
  }
}