/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.reactnativecommunity.viewpager.event;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted by {@link ReactViewPager} when user scrolling state changed.
 *
 * Additional data provided by this event:
 *  - pageScrollState - {Idle,Dragging,Settling}
 */
public class PageScrollStateChangedEvent extends Event<PageScrollStateChangedEvent> {

  public static final String EVENT_NAME = "topPageScrollStateChanged";

  private final String mPageScrollState;

  public PageScrollStateChangedEvent(int viewTag, String pageScrollState) {
    super(viewTag);
    mPageScrollState = pageScrollState;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  private WritableMap serializeEventData() {
    WritableMap eventData = Arguments.createMap();
    eventData.putString("pageScrollState", mPageScrollState);
    return eventData;
  }
}
