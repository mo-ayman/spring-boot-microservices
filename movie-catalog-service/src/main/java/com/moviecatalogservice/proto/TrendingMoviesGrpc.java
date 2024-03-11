package com.moviecatalogservice.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: TrendingMovies.proto")
public final class TrendingMoviesGrpc {

  private TrendingMoviesGrpc() {}

  public static final String SERVICE_NAME = "TrendingMovies";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty,
      com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply> getGetTopTenMoviesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTopTenMovies",
      requestType = com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty.class,
      responseType = com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty,
      com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply> getGetTopTenMoviesMethod() {
    io.grpc.MethodDescriptor<com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty, com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply> getGetTopTenMoviesMethod;
    if ((getGetTopTenMoviesMethod = TrendingMoviesGrpc.getGetTopTenMoviesMethod) == null) {
      synchronized (TrendingMoviesGrpc.class) {
        if ((getGetTopTenMoviesMethod = TrendingMoviesGrpc.getGetTopTenMoviesMethod) == null) {
          TrendingMoviesGrpc.getGetTopTenMoviesMethod = getGetTopTenMoviesMethod = 
              io.grpc.MethodDescriptor.<com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty, com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "TrendingMovies", "GetTopTenMovies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TrendingMoviesMethodDescriptorSupplier("GetTopTenMovies"))
                  .build();
          }
        }
     }
     return getGetTopTenMoviesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrendingMoviesStub newStub(io.grpc.Channel channel) {
    return new TrendingMoviesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrendingMoviesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrendingMoviesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrendingMoviesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrendingMoviesFutureStub(channel);
  }

  /**
   */
  public static abstract class TrendingMoviesImplBase implements io.grpc.BindableService {

    /**
     */
    public void getTopTenMovies(com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty request,
        io.grpc.stub.StreamObserver<com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTopTenMoviesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTopTenMoviesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty,
                com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply>(
                  this, METHODID_GET_TOP_TEN_MOVIES)))
          .build();
    }
  }

  /**
   */
  public static final class TrendingMoviesStub extends io.grpc.stub.AbstractStub<TrendingMoviesStub> {
    private TrendingMoviesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingMoviesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingMoviesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingMoviesStub(channel, callOptions);
    }

    /**
     */
    public void getTopTenMovies(com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty request,
        io.grpc.stub.StreamObserver<com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTopTenMoviesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TrendingMoviesBlockingStub extends io.grpc.stub.AbstractStub<TrendingMoviesBlockingStub> {
    private TrendingMoviesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingMoviesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingMoviesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingMoviesBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply getTopTenMovies(com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetTopTenMoviesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TrendingMoviesFutureStub extends io.grpc.stub.AbstractStub<TrendingMoviesFutureStub> {
    private TrendingMoviesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrendingMoviesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrendingMoviesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrendingMoviesFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply> getTopTenMovies(
        com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTopTenMoviesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOP_TEN_MOVIES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrendingMoviesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrendingMoviesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOP_TEN_MOVIES:
          serviceImpl.getTopTenMovies((com.moviecatalogservice.proto.TrendingMoviesOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<com.moviecatalogservice.proto.TrendingMoviesOuterClass.GetTopTenMoviesReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TrendingMoviesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrendingMoviesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.moviecatalogservice.proto.TrendingMoviesOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrendingMovies");
    }
  }

  private static final class TrendingMoviesFileDescriptorSupplier
      extends TrendingMoviesBaseDescriptorSupplier {
    TrendingMoviesFileDescriptorSupplier() {}
  }

  private static final class TrendingMoviesMethodDescriptorSupplier
      extends TrendingMoviesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrendingMoviesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrendingMoviesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrendingMoviesFileDescriptorSupplier())
              .addMethod(getGetTopTenMoviesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
