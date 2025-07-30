FROM fluent/fluentd:v1.16.2-debian-1.0

# Use root account to install dependencies
USER root

# Install plugins and dependencies
RUN buildDeps="sudo make gcc g++ libc-dev ruby-dev" \
 && apt-get update \
 && apt-get install -y --no-install-recommends $buildDeps curl \
 && gem install fluent-plugin-elasticsearch -v 5.4.3 --no-document \
 && gem install fluent-plugin-rewrite-tag-filter --no-document \
 && gem sources --clear-all \
 && SUDO_FORCE_REMOVE=yes \
    apt-get purge -y --auto-remove \
                  -o APT::AutoRemove::RecommendsImportant=false \
                  $buildDeps \
 && rm -rf /var/lib/apt/lists/* \
 && rm -rf /tmp/* /var/tmp/* /usr/lib/ruby/gems/*/cache/*.gem

# Create buffer directory with proper permissions
RUN mkdir -p /tmp/fluentd-buffers \
 && chown -R fluent:fluent /tmp/fluentd-buffers \
 && chmod 755 /tmp/fluentd-buffers

# Switch back to fluent user
USER fluent

# Set working directory
WORKDIR /home/fluent

# Command to run fluentd
CMD ["fluentd", "-c", "/fluentd/etc/fluent.conf", "-v"]