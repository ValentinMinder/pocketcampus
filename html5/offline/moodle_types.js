//
// Autogenerated by Thrift Compiler (0.8.0-dev)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//

MoodleEventType = {
'MOODLE_EVENT_UNKNOWN' : 0,
'MOODLE_EVENT_ASSIGNMENT' : 1,
'MOODLE_EVENT_USEREVENT' : 2
};
MoodleRequest = function(args) {
  this.iSessionId = null;
  this.iLanguage = null;
  this.iCourseId = null;
  if (args) {
    if (args.iSessionId !== undefined) {
      this.iSessionId = args.iSessionId;
    }
    if (args.iLanguage !== undefined) {
      this.iLanguage = args.iLanguage;
    }
    if (args.iCourseId !== undefined) {
      this.iCourseId = args.iCourseId;
    }
  }
};
MoodleRequest.prototype = {};
MoodleRequest.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRUCT) {
        this.iSessionId = new SessionId();
        this.iSessionId.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.iLanguage = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.I32) {
        this.iCourseId = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleRequest.prototype.write = function(output) {
  output.writeStructBegin('MoodleRequest');
  if (this.iSessionId) {
    output.writeFieldBegin('iSessionId', Thrift.Type.STRUCT, 1);
    this.iSessionId.write(output);
    output.writeFieldEnd();
  }
  if (this.iLanguage) {
    output.writeFieldBegin('iLanguage', Thrift.Type.STRING, 2);
    output.writeString(this.iLanguage);
    output.writeFieldEnd();
  }
  if (this.iCourseId) {
    output.writeFieldBegin('iCourseId', Thrift.Type.I32, 3);
    output.writeI32(this.iCourseId);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MoodleSession = function(args) {
  this.moodleCookie = null;
  if (args) {
    if (args.moodleCookie !== undefined) {
      this.moodleCookie = args.moodleCookie;
    }
  }
};
MoodleSession.prototype = {};
MoodleSession.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.moodleCookie = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 0:
        input.skip(ftype);
        break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleSession.prototype.write = function(output) {
  output.writeStructBegin('MoodleSession');
  if (this.moodleCookie) {
    output.writeFieldBegin('moodleCookie', Thrift.Type.STRING, 1);
    output.writeString(this.moodleCookie);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MoodleCourse = function(args) {
  this.iId = null;
  this.iTitle = null;
  if (args) {
    if (args.iId !== undefined) {
      this.iId = args.iId;
    }
    if (args.iTitle !== undefined) {
      this.iTitle = args.iTitle;
    }
  }
};
MoodleCourse.prototype = {};
MoodleCourse.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.I32) {
        this.iId = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.iTitle = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleCourse.prototype.write = function(output) {
  output.writeStructBegin('MoodleCourse');
  if (this.iId) {
    output.writeFieldBegin('iId', Thrift.Type.I32, 1);
    output.writeI32(this.iId);
    output.writeFieldEnd();
  }
  if (this.iTitle) {
    output.writeFieldBegin('iTitle', Thrift.Type.STRING, 2);
    output.writeString(this.iTitle);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

CoursesListReply = function(args) {
  this.iCourses = null;
  this.iStatus = null;
  if (args) {
    if (args.iCourses !== undefined) {
      this.iCourses = args.iCourses;
    }
    if (args.iStatus !== undefined) {
      this.iStatus = args.iStatus;
    }
  }
};
CoursesListReply.prototype = {};
CoursesListReply.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.LIST) {
        var _size0 = 0;
        var _rtmp34;
        this.iCourses = [];
        var _etype3 = 0;
        _rtmp34 = input.readListBegin();
        _etype3 = _rtmp34.etype;
        _size0 = _rtmp34.size;
        for (var _i5 = 0; _i5 < _size0; ++_i5)
        {
          var elem6 = null;
          elem6 = new MoodleCourse();
          elem6.read(input);
          this.iCourses.push(elem6);
        }
        input.readListEnd();
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.I32) {
        this.iStatus = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

CoursesListReply.prototype.write = function(output) {
  output.writeStructBegin('CoursesListReply');
  if (this.iCourses) {
    output.writeFieldBegin('iCourses', Thrift.Type.LIST, 1);
    output.writeListBegin(Thrift.Type.STRUCT, this.iCourses.length);
    for (var iter7 in this.iCourses)
    {
      if (this.iCourses.hasOwnProperty(iter7))
      {
        iter7 = this.iCourses[iter7];
        iter7.write(output);
      }
    }
    output.writeListEnd();
    output.writeFieldEnd();
  }
  if (this.iStatus) {
    output.writeFieldBegin('iStatus', Thrift.Type.I32, 2);
    output.writeI32(this.iStatus);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MoodleAssignment = function(args) {
  this.iId = null;
  this.iTitle = null;
  this.iDesc = null;
  this.iCourse = null;
  this.iPostingDate = null;
  this.iDueDate = null;
  this.iGrade = null;
  if (args) {
    if (args.iId !== undefined) {
      this.iId = args.iId;
    }
    if (args.iTitle !== undefined) {
      this.iTitle = args.iTitle;
    }
    if (args.iDesc !== undefined) {
      this.iDesc = args.iDesc;
    }
    if (args.iCourse !== undefined) {
      this.iCourse = args.iCourse;
    }
    if (args.iPostingDate !== undefined) {
      this.iPostingDate = args.iPostingDate;
    }
    if (args.iDueDate !== undefined) {
      this.iDueDate = args.iDueDate;
    }
    if (args.iGrade !== undefined) {
      this.iGrade = args.iGrade;
    }
  }
};
MoodleAssignment.prototype = {};
MoodleAssignment.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.I32) {
        this.iId = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.iTitle = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.STRING) {
        this.iDesc = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 4:
      if (ftype == Thrift.Type.STRUCT) {
        this.iCourse = new MoodleCourse();
        this.iCourse.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 5:
      if (ftype == Thrift.Type.I64) {
        this.iPostingDate = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 6:
      if (ftype == Thrift.Type.I64) {
        this.iDueDate = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 7:
      if (ftype == Thrift.Type.STRING) {
        this.iGrade = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleAssignment.prototype.write = function(output) {
  output.writeStructBegin('MoodleAssignment');
  if (this.iId) {
    output.writeFieldBegin('iId', Thrift.Type.I32, 1);
    output.writeI32(this.iId);
    output.writeFieldEnd();
  }
  if (this.iTitle) {
    output.writeFieldBegin('iTitle', Thrift.Type.STRING, 2);
    output.writeString(this.iTitle);
    output.writeFieldEnd();
  }
  if (this.iDesc) {
    output.writeFieldBegin('iDesc', Thrift.Type.STRING, 3);
    output.writeString(this.iDesc);
    output.writeFieldEnd();
  }
  if (this.iCourse) {
    output.writeFieldBegin('iCourse', Thrift.Type.STRUCT, 4);
    this.iCourse.write(output);
    output.writeFieldEnd();
  }
  if (this.iPostingDate) {
    output.writeFieldBegin('iPostingDate', Thrift.Type.I64, 5);
    output.writeI64(this.iPostingDate);
    output.writeFieldEnd();
  }
  if (this.iDueDate) {
    output.writeFieldBegin('iDueDate', Thrift.Type.I64, 6);
    output.writeI64(this.iDueDate);
    output.writeFieldEnd();
  }
  if (this.iGrade) {
    output.writeFieldBegin('iGrade', Thrift.Type.STRING, 7);
    output.writeString(this.iGrade);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MoodleUserEvent = function(args) {
  this.iId = null;
  this.iTitle = null;
  this.iDesc = null;
  this.iStartDate = null;
  this.iEndDate = null;
  if (args) {
    if (args.iId !== undefined) {
      this.iId = args.iId;
    }
    if (args.iTitle !== undefined) {
      this.iTitle = args.iTitle;
    }
    if (args.iDesc !== undefined) {
      this.iDesc = args.iDesc;
    }
    if (args.iStartDate !== undefined) {
      this.iStartDate = args.iStartDate;
    }
    if (args.iEndDate !== undefined) {
      this.iEndDate = args.iEndDate;
    }
  }
};
MoodleUserEvent.prototype = {};
MoodleUserEvent.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.I32) {
        this.iId = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.iTitle = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.STRING) {
        this.iDesc = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 4:
      if (ftype == Thrift.Type.I64) {
        this.iStartDate = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 5:
      if (ftype == Thrift.Type.I64) {
        this.iEndDate = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleUserEvent.prototype.write = function(output) {
  output.writeStructBegin('MoodleUserEvent');
  if (this.iId) {
    output.writeFieldBegin('iId', Thrift.Type.I32, 1);
    output.writeI32(this.iId);
    output.writeFieldEnd();
  }
  if (this.iTitle) {
    output.writeFieldBegin('iTitle', Thrift.Type.STRING, 2);
    output.writeString(this.iTitle);
    output.writeFieldEnd();
  }
  if (this.iDesc) {
    output.writeFieldBegin('iDesc', Thrift.Type.STRING, 3);
    output.writeString(this.iDesc);
    output.writeFieldEnd();
  }
  if (this.iStartDate) {
    output.writeFieldBegin('iStartDate', Thrift.Type.I64, 4);
    output.writeI64(this.iStartDate);
    output.writeFieldEnd();
  }
  if (this.iEndDate) {
    output.writeFieldBegin('iEndDate', Thrift.Type.I64, 5);
    output.writeI64(this.iEndDate);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MoodleEvent = function(args) {
  this.iId = null;
  this.iTitle = null;
  this.iDate = null;
  this.iType = null;
  this.iAssignment = null;
  this.iUserEvent = null;
  if (args) {
    if (args.iId !== undefined) {
      this.iId = args.iId;
    }
    if (args.iTitle !== undefined) {
      this.iTitle = args.iTitle;
    }
    if (args.iDate !== undefined) {
      this.iDate = args.iDate;
    }
    if (args.iType !== undefined) {
      this.iType = args.iType;
    }
    if (args.iAssignment !== undefined) {
      this.iAssignment = args.iAssignment;
    }
    if (args.iUserEvent !== undefined) {
      this.iUserEvent = args.iUserEvent;
    }
  }
};
MoodleEvent.prototype = {};
MoodleEvent.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.I32) {
        this.iId = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.iTitle = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.I64) {
        this.iDate = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 4:
      if (ftype == Thrift.Type.I32) {
        this.iType = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 5:
      if (ftype == Thrift.Type.STRUCT) {
        this.iAssignment = new MoodleAssignment();
        this.iAssignment.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      case 6:
      if (ftype == Thrift.Type.STRUCT) {
        this.iUserEvent = new MoodleUserEvent();
        this.iUserEvent.read(input);
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleEvent.prototype.write = function(output) {
  output.writeStructBegin('MoodleEvent');
  if (this.iId) {
    output.writeFieldBegin('iId', Thrift.Type.I32, 1);
    output.writeI32(this.iId);
    output.writeFieldEnd();
  }
  if (this.iTitle) {
    output.writeFieldBegin('iTitle', Thrift.Type.STRING, 2);
    output.writeString(this.iTitle);
    output.writeFieldEnd();
  }
  if (this.iDate) {
    output.writeFieldBegin('iDate', Thrift.Type.I64, 3);
    output.writeI64(this.iDate);
    output.writeFieldEnd();
  }
  if (this.iType) {
    output.writeFieldBegin('iType', Thrift.Type.I32, 4);
    output.writeI32(this.iType);
    output.writeFieldEnd();
  }
  if (this.iAssignment) {
    output.writeFieldBegin('iAssignment', Thrift.Type.STRUCT, 5);
    this.iAssignment.write(output);
    output.writeFieldEnd();
  }
  if (this.iUserEvent) {
    output.writeFieldBegin('iUserEvent', Thrift.Type.STRUCT, 6);
    this.iUserEvent.write(output);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

EventsListReply = function(args) {
  this.iEvents = null;
  this.iStatus = null;
  if (args) {
    if (args.iEvents !== undefined) {
      this.iEvents = args.iEvents;
    }
    if (args.iStatus !== undefined) {
      this.iStatus = args.iStatus;
    }
  }
};
EventsListReply.prototype = {};
EventsListReply.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.LIST) {
        var _size8 = 0;
        var _rtmp312;
        this.iEvents = [];
        var _etype11 = 0;
        _rtmp312 = input.readListBegin();
        _etype11 = _rtmp312.etype;
        _size8 = _rtmp312.size;
        for (var _i13 = 0; _i13 < _size8; ++_i13)
        {
          var elem14 = null;
          elem14 = new MoodleEvent();
          elem14.read(input);
          this.iEvents.push(elem14);
        }
        input.readListEnd();
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.I32) {
        this.iStatus = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

EventsListReply.prototype.write = function(output) {
  output.writeStructBegin('EventsListReply');
  if (this.iEvents) {
    output.writeFieldBegin('iEvents', Thrift.Type.LIST, 1);
    output.writeListBegin(Thrift.Type.STRUCT, this.iEvents.length);
    for (var iter15 in this.iEvents)
    {
      if (this.iEvents.hasOwnProperty(iter15))
      {
        iter15 = this.iEvents[iter15];
        iter15.write(output);
      }
    }
    output.writeListEnd();
    output.writeFieldEnd();
  }
  if (this.iStatus) {
    output.writeFieldBegin('iStatus', Thrift.Type.I32, 2);
    output.writeI32(this.iStatus);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MoodleResource = function(args) {
  this.iName = null;
  this.iUrl = null;
  if (args) {
    if (args.iName !== undefined) {
      this.iName = args.iName;
    }
    if (args.iUrl !== undefined) {
      this.iUrl = args.iUrl;
    }
  }
};
MoodleResource.prototype = {};
MoodleResource.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.iName = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.iUrl = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleResource.prototype.write = function(output) {
  output.writeStructBegin('MoodleResource');
  if (this.iName) {
    output.writeFieldBegin('iName', Thrift.Type.STRING, 1);
    output.writeString(this.iName);
    output.writeFieldEnd();
  }
  if (this.iUrl) {
    output.writeFieldBegin('iUrl', Thrift.Type.STRING, 2);
    output.writeString(this.iUrl);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

MoodleSection = function(args) {
  this.iResources = null;
  this.iText = null;
  this.iStartDate = null;
  this.iEndDate = null;
  this.iCurrent = null;
  if (args) {
    if (args.iResources !== undefined) {
      this.iResources = args.iResources;
    }
    if (args.iText !== undefined) {
      this.iText = args.iText;
    }
    if (args.iStartDate !== undefined) {
      this.iStartDate = args.iStartDate;
    }
    if (args.iEndDate !== undefined) {
      this.iEndDate = args.iEndDate;
    }
    if (args.iCurrent !== undefined) {
      this.iCurrent = args.iCurrent;
    }
  }
};
MoodleSection.prototype = {};
MoodleSection.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.LIST) {
        var _size16 = 0;
        var _rtmp320;
        this.iResources = [];
        var _etype19 = 0;
        _rtmp320 = input.readListBegin();
        _etype19 = _rtmp320.etype;
        _size16 = _rtmp320.size;
        for (var _i21 = 0; _i21 < _size16; ++_i21)
        {
          var elem22 = null;
          elem22 = new MoodleResource();
          elem22.read(input);
          this.iResources.push(elem22);
        }
        input.readListEnd();
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.iText = input.readString().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.I64) {
        this.iStartDate = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 4:
      if (ftype == Thrift.Type.I64) {
        this.iEndDate = input.readI64().value;
      } else {
        input.skip(ftype);
      }
      break;
      case 5:
      if (ftype == Thrift.Type.BOOL) {
        this.iCurrent = input.readBool().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

MoodleSection.prototype.write = function(output) {
  output.writeStructBegin('MoodleSection');
  if (this.iResources) {
    output.writeFieldBegin('iResources', Thrift.Type.LIST, 1);
    output.writeListBegin(Thrift.Type.STRUCT, this.iResources.length);
    for (var iter23 in this.iResources)
    {
      if (this.iResources.hasOwnProperty(iter23))
      {
        iter23 = this.iResources[iter23];
        iter23.write(output);
      }
    }
    output.writeListEnd();
    output.writeFieldEnd();
  }
  if (this.iText) {
    output.writeFieldBegin('iText', Thrift.Type.STRING, 2);
    output.writeString(this.iText);
    output.writeFieldEnd();
  }
  if (this.iStartDate) {
    output.writeFieldBegin('iStartDate', Thrift.Type.I64, 3);
    output.writeI64(this.iStartDate);
    output.writeFieldEnd();
  }
  if (this.iEndDate) {
    output.writeFieldBegin('iEndDate', Thrift.Type.I64, 4);
    output.writeI64(this.iEndDate);
    output.writeFieldEnd();
  }
  if (this.iCurrent) {
    output.writeFieldBegin('iCurrent', Thrift.Type.BOOL, 5);
    output.writeBool(this.iCurrent);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

SectionsListReply = function(args) {
  this.iSections = null;
  this.iStatus = null;
  if (args) {
    if (args.iSections !== undefined) {
      this.iSections = args.iSections;
    }
    if (args.iStatus !== undefined) {
      this.iStatus = args.iStatus;
    }
  }
};
SectionsListReply.prototype = {};
SectionsListReply.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.LIST) {
        var _size24 = 0;
        var _rtmp328;
        this.iSections = [];
        var _etype27 = 0;
        _rtmp328 = input.readListBegin();
        _etype27 = _rtmp328.etype;
        _size24 = _rtmp328.size;
        for (var _i29 = 0; _i29 < _size24; ++_i29)
        {
          var elem30 = null;
          elem30 = new MoodleSection();
          elem30.read(input);
          this.iSections.push(elem30);
        }
        input.readListEnd();
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.I32) {
        this.iStatus = input.readI32().value;
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

SectionsListReply.prototype.write = function(output) {
  output.writeStructBegin('SectionsListReply');
  if (this.iSections) {
    output.writeFieldBegin('iSections', Thrift.Type.LIST, 1);
    output.writeListBegin(Thrift.Type.STRUCT, this.iSections.length);
    for (var iter31 in this.iSections)
    {
      if (this.iSections.hasOwnProperty(iter31))
      {
        iter31 = this.iSections[iter31];
        iter31.write(output);
      }
    }
    output.writeListEnd();
    output.writeFieldEnd();
  }
  if (this.iStatus) {
    output.writeFieldBegin('iStatus', Thrift.Type.I32, 2);
    output.writeI32(this.iStatus);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};
