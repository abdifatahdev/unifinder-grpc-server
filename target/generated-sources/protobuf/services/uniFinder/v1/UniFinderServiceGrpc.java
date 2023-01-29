package services.uniFinder.v1;

import org.json.JSONException;

import java.io.IOException;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: uni_finder.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UniFinderServiceGrpc {

  private UniFinderServiceGrpc() {}

  public static final String SERVICE_NAME = "services.uniFinder.v1.UniFinderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<services.uniFinder.v1.UniFinder.UniFinderRequest,
      services.uniFinder.v1.UniFinder.UniFinderResponse> getGetUniFinderInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUniFinderInfo",
      requestType = services.uniFinder.v1.UniFinder.UniFinderRequest.class,
      responseType = services.uniFinder.v1.UniFinder.UniFinderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<services.uniFinder.v1.UniFinder.UniFinderRequest,
      services.uniFinder.v1.UniFinder.UniFinderResponse> getGetUniFinderInfoMethod() {
    io.grpc.MethodDescriptor<services.uniFinder.v1.UniFinder.UniFinderRequest, services.uniFinder.v1.UniFinder.UniFinderResponse> getGetUniFinderInfoMethod;
    if ((getGetUniFinderInfoMethod = UniFinderServiceGrpc.getGetUniFinderInfoMethod) == null) {
      synchronized (UniFinderServiceGrpc.class) {
        if ((getGetUniFinderInfoMethod = UniFinderServiceGrpc.getGetUniFinderInfoMethod) == null) {
          UniFinderServiceGrpc.getGetUniFinderInfoMethod = getGetUniFinderInfoMethod =
              io.grpc.MethodDescriptor.<services.uniFinder.v1.UniFinder.UniFinderRequest, services.uniFinder.v1.UniFinder.UniFinderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUniFinderInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.uniFinder.v1.UniFinder.UniFinderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  services.uniFinder.v1.UniFinder.UniFinderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UniFinderServiceMethodDescriptorSupplier("GetUniFinderInfo"))
              .build();
        }
      }
    }
    return getGetUniFinderInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UniFinderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UniFinderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UniFinderServiceStub>() {
        @java.lang.Override
        public UniFinderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UniFinderServiceStub(channel, callOptions);
        }
      };
    return UniFinderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UniFinderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UniFinderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UniFinderServiceBlockingStub>() {
        @java.lang.Override
        public UniFinderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UniFinderServiceBlockingStub(channel, callOptions);
        }
      };
    return UniFinderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UniFinderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UniFinderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UniFinderServiceFutureStub>() {
        @java.lang.Override
        public UniFinderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UniFinderServiceFutureStub(channel, callOptions);
        }
      };
    return UniFinderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UniFinderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUniFinderInfo(services.uniFinder.v1.UniFinder.UniFinderRequest request,
        io.grpc.stub.StreamObserver<services.uniFinder.v1.UniFinder.UniFinderResponse> responseObserver) throws JSONException, IOException, InterruptedException {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUniFinderInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUniFinderInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                services.uniFinder.v1.UniFinder.UniFinderRequest,
                services.uniFinder.v1.UniFinder.UniFinderResponse>(
                  this, METHODID_GET_UNI_FINDER_INFO)))
          .build();
    }
  }

  /**
   */
  public static final class UniFinderServiceStub extends io.grpc.stub.AbstractAsyncStub<UniFinderServiceStub> {
    private UniFinderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UniFinderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UniFinderServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUniFinderInfo(services.uniFinder.v1.UniFinder.UniFinderRequest request,
        io.grpc.stub.StreamObserver<services.uniFinder.v1.UniFinder.UniFinderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUniFinderInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UniFinderServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UniFinderServiceBlockingStub> {
    private UniFinderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UniFinderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UniFinderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public services.uniFinder.v1.UniFinder.UniFinderResponse getUniFinderInfo(services.uniFinder.v1.UniFinder.UniFinderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUniFinderInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UniFinderServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UniFinderServiceFutureStub> {
    private UniFinderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UniFinderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UniFinderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<services.uniFinder.v1.UniFinder.UniFinderResponse> getUniFinderInfo(
        services.uniFinder.v1.UniFinder.UniFinderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUniFinderInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_UNI_FINDER_INFO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UniFinderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UniFinderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_UNI_FINDER_INFO:
          try {
            serviceImpl.getUniFinderInfo((UniFinder.UniFinderRequest) request,
                (io.grpc.stub.StreamObserver<UniFinder.UniFinderResponse>) responseObserver);
          } catch (JSONException e) {
            throw new RuntimeException(e);
          } catch (IOException e) {
            throw new RuntimeException(e);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
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

  private static abstract class UniFinderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UniFinderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return services.uniFinder.v1.UniFinder.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UniFinderService");
    }
  }

  private static final class UniFinderServiceFileDescriptorSupplier
      extends UniFinderServiceBaseDescriptorSupplier {
    UniFinderServiceFileDescriptorSupplier() {}
  }

  private static final class UniFinderServiceMethodDescriptorSupplier
      extends UniFinderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UniFinderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UniFinderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UniFinderServiceFileDescriptorSupplier())
              .addMethod(getGetUniFinderInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
