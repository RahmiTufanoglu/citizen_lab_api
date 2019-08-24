package com.rahmitufanoglu.citizenlab.util;

import com.rahmitufanoglu.citizenlab.model.User;
import java.util.Comparator;

public class UserComparator implements Comparator<User> {

  @Override
  public int compare(User x, User y) {
    return x.getUserId().compareTo(y.getUserId());
  }
}
