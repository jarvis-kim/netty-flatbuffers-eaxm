// automatically generated by the FlatBuffers compiler, do not modify

/**
 * @const
 * @namespace
 */
var kr = kr || {};

/**
 * @const
 * @namespace
 */
kr.co = kr.co || {};

/**
 * @const
 * @namespace
 */
kr.co.jarvisk = kr.co.jarvisk || {};

/**
 * @const
 * @namespace
 */
kr.co.jarvisk.flatbuffers = kr.co.jarvisk.flatbuffers || {};

/**
 * @const
 * @namespace
 */
kr.co.jarvisk.flatbuffers.protocol = kr.co.jarvisk.flatbuffers.protocol || {};

/**
 * @constructor
 */
kr.co.jarvisk.flatbuffers.protocol.Hello = function() {
  /**
   * @type {flatbuffers.ByteBuffer}
   */
  this.bb = null;

  /**
   * @type {number}
   */
  this.bb_pos = 0;
};

/**
 * @param {number} i
 * @param {flatbuffers.ByteBuffer} bb
 * @returns {kr.co.jarvisk.flatbuffers.protocol.Hello}
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.prototype.__init = function(i, bb) {
  this.bb_pos = i;
  this.bb = bb;
  return this;
};

/**
 * @param {flatbuffers.ByteBuffer} bb
 * @param {kr.co.jarvisk.flatbuffers.protocol.Hello=} obj
 * @returns {kr.co.jarvisk.flatbuffers.protocol.Hello}
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.getRootAsHello = function(bb, obj) {
  return (obj || new kr.co.jarvisk.flatbuffers.protocol.Hello).__init(bb.readInt32(bb.position()) + bb.position(), bb);
};

/**
 * @param {flatbuffers.Encoding=} optionalEncoding
 * @returns {string|Uint8Array}
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.prototype.message = function(optionalEncoding) {
  var offset = this.bb.__offset(this.bb_pos, 4);
  return offset ? this.bb.__string(this.bb_pos + offset, optionalEncoding) : null;
};

/**
 * @param {flatbuffers.Encoding=} optionalEncoding
 * @returns {string|Uint8Array}
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.prototype.name = function(optionalEncoding) {
  var offset = this.bb.__offset(this.bb_pos, 6);
  return offset ? this.bb.__string(this.bb_pos + offset, optionalEncoding) : null;
};

/**
 * @returns {number}
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.prototype.count = function() {
  var offset = this.bb.__offset(this.bb_pos, 8);
  return offset ? this.bb.readInt32(this.bb_pos + offset) : 0;
};

/**
 * @param {flatbuffers.Builder} builder
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.startHello = function(builder) {
  builder.startObject(3);
};

/**
 * @param {flatbuffers.Builder} builder
 * @param {flatbuffers.Offset} messageOffset
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.addMessage = function(builder, messageOffset) {
  builder.addFieldOffset(0, messageOffset, 0);
};

/**
 * @param {flatbuffers.Builder} builder
 * @param {flatbuffers.Offset} nameOffset
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.addName = function(builder, nameOffset) {
  builder.addFieldOffset(1, nameOffset, 0);
};

/**
 * @param {flatbuffers.Builder} builder
 * @param {number} count
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.addCount = function(builder, count) {
  builder.addFieldInt32(2, count, 0);
};

/**
 * @param {flatbuffers.Builder} builder
 * @returns {flatbuffers.Offset}
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.endHello = function(builder) {
  var offset = builder.endObject();
  return offset;
};

/**
 * @param {flatbuffers.Builder} builder
 * @param {flatbuffers.Offset} offset
 */
kr.co.jarvisk.flatbuffers.protocol.Hello.finishHelloBuffer = function(builder, offset) {
  builder.finish(offset);
};

// Exports for Node.js and RequireJS
this.kr = kr;